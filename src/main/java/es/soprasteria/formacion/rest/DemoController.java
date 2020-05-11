package es.soprasteria.formacion.rest;

import es.soprasteria.formacion.dto.PersonDto;
import es.soprasteria.formacion.service.PersonService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

  @Autowired
  private PersonService personService;

  @ApiOperation(value="Este método saluda a un usuario")
  @ApiResponses(value = {
      @ApiResponse(code = 200, message = "Llamada ejecutada correctamente"),
      @ApiResponse(code = 500, message = "Error inesperado"),
  })
  @GetMapping("/hello/{name}")
  public String hello(@ApiParam(value="El usuario a saludar") @PathVariable(name="name") String name) {
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
