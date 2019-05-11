package com.example.demo.rest;

import com.example.demo.model.Persona;
import com.example.demo.repository.IPersonaRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.List;

import org.hibernate.validator.constraints.time.DurationMax;
import org.hibernate.validator.constraints.time.DurationMin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Api(value = "API REST personas")
@RestController
public class RestDemoController {

  @Autowired
  private IPersonaRepository repo;

  @ApiOperation(value = "Retorna lista de personas")
  @GetMapping
  @RequestMapping("/personas")
  @DurationMax
  @DurationMin
  public List<Persona> listar() {
    return repo.findAll();

  }

  @ApiOperation(value = "registra lista de personas")
  @PostMapping
  // @RequestMapping("/inserPersonas")
  public void insertar(@RequestBody Persona per) {
    repo.save(per);

  }

  @ApiOperation(value = "Modifica lista de personas")
  @PutMapping
  // @RequestMapping("/modPersonas")
  public void modificar(@RequestBody Persona per) {
    repo.save(per);

  }

  @DeleteMapping("/personas/{id}")
  public void eliminar(@PathVariable("id") Integer id) {
    repo.deleteById(id);

  }
}
