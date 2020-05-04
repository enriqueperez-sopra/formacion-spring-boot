package es.soprasteria.formacion.rest;

import es.soprasteria.formacion.dao.PersonRepository;
import es.soprasteria.formacion.entity.PersonEntity;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

  @Autowired
  private PersonRepository personRepository;

  @GetMapping("/hello/{name}")
  public String hello(@PathVariable(name="name") String name) {
    return "Hello " + name;
  }

  @GetMapping("/list/{name}")
  public PersonEntity findPerson(@PathVariable(name="name") String name) {
    return personRepository.findById(name).get();
  }

  @GetMapping("/list")
  public List<PersonEntity> listPersons() {
    return personRepository.findAll();
  }
}
