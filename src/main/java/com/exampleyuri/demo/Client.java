package com.exampleyuri.demo;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;;

@Entity
public class Client
{
    @Id
    @Column(name="id")
    private int Id;
    @Column(name="name")
    private String Nombre;
    @Column(name="lastname")
    private String Apellidos;
    @Column(name="age")
    private int Edad;
    //@Column(name="birthdate")
    //private Date FechaNacimiento;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        this.Id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public int getEdad() {
        return Edad;
    }

    public void setEdad(int edad) {
        this.Edad = edad;
    }

    /*public Date getFechaNacimiento() {
        return FechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.FechaNacimiento = fechaNacimiento;
    }*/

    public void setNombre(String nombre) {
        this.Nombre = nombre;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String apellidos) {
        this.Apellidos = apellidos;
    }
}
