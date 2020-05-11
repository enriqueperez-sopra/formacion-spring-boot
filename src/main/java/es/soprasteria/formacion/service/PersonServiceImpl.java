package es.soprasteria.formacion.service;

import es.soprasteria.formacion.dao.PersonRepository;
import es.soprasteria.formacion.dto.PersonDto;
import es.soprasteria.formacion.entity.PersonEntity;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {

  @Autowired
  private PersonRepository personRepository;

  @Override
  public PersonDto getByName(String name) {
    PersonEntity entity = personRepository.findById(name).get();
    PersonDto dto = new PersonDto(entity.getName(), entity.getAge());
    return dto;
  }

  @Override
  public List<PersonDto> getAllPersons() {
    List<PersonEntity> entities = personRepository.findAll();
    List<PersonDto> personDtos = entities.stream()
        .map(personEntity -> new PersonDto(personEntity.getName(), personEntity.getAge()))
        .collect(Collectors.toList());
    return personDtos;
  }

  @Override
  public PersonDto createPerson(PersonDto newPerson) {
    PersonEntity personEntity = new PersonEntity();
    personEntity.setAge(newPerson.getAge());
    personEntity.setName(newPerson.getName());

    PersonEntity persistedEntity = personRepository.save(personEntity);

    PersonDto personDto = new PersonDto(persistedEntity.getName(), persistedEntity.getAge());
    return personDto;
  }
}
