package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Persona {

  @Id
  private int idPersona;

  @Column(name = "dni", length = 10)
    private String dni;
  @Column(name = "nombre", length = 50)
    private String nombre;

  public int getIdPersona() {
    return idPersona;
  }

  public void setIdPersona(int idPersona) {
    this.idPersona = idPersona;
  }

  public String getDni() {
    return dni;
  }

  public void setDni(String dni) {
    this.dni = dni;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

}
