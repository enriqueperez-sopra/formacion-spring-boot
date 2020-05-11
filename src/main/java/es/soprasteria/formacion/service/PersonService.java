package es.soprasteria.formacion.service;

import es.soprasteria.formacion.dto.PersonDto;
import java.util.List;

public interface PersonService {

  PersonDto getByName(String name);

  List<PersonDto> getAllPersons();

  PersonDto createPerson(PersonDto newPerson);
}
