package com.example.demo.controllers;

import com.example.demo.model.Persona;
import com.example.demo.repository.IPersonaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/holas")
public class DemoController1 {

  @Autowired
  private IPersonaRepository repo;

  /**
   * REGISTRAR.
   * 
   * @param name  SALUDO.
   * @param model Registrar una persona
   * @return un registro
   */
  @GetMapping(path = { "/saludar", "/holamundo" })
  public String saludar(@RequestParam(name = "name", required = false, defaultValue = "World") 
      String name, Model model) {

    // logica
    Persona per = new Persona();
    per.setIdPersona(1);
    per.setDni("12345678");
    per.setNombre("Rosmery");
    repo.save(per);

    model.addAttribute("nombre", name);
    return "index";
  }

  /**
   * LISTAR.
   * 
   * @param model MODELO.
   * @return listado.
   */
  @GetMapping("/listar")
  public String listar(Model model) {

    // logica
    model.addAttribute("personas", repo.findAll());

    return "index";
  }
}
