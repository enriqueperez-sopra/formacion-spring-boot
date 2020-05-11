package es.soprasteria.formacion.rest;

import es.soprasteria.formacion.dto.PersonDto;
import es.soprasteria.formacion.service.PersonService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

  @Autowired
  private PersonService personService;

  @GetMapping("/hello/{name}")
  public String hello(@PathVariable(name="name") String name) {
    return "Hello " + name;
  }

  @GetMapping("/list/{name}")
  public PersonDto findPerson(@PathVariable(name="name") String name) {
    return personService.getByName(name);
  }

  @GetMapping("/list")
  public List<PersonDto> listPersons() {
    return personService.getAllPersons();
  }
}
