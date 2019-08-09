package com.exampleyuri.demo.Model;


import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class Client
{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private int Id;

    @NotNull
    @Column(name="name")
    private String Nombre;

    @NotNull
    @Column(name="lastname")
    private String Apellido;

    @Column(name="age")
    private int Edad;

    @NotNull
    @Past
    @Column(name="birthdate")
    private Date FechaNacimiento;
    
    @Transient
    private Date fechaProbableMuerte;

    /*public Client()
    {
        this.fechaProbableMuerte = Util.calcularFechaDeceso(this.FechaNacimiento);
    }*/

    @ApiModelProperty(hidden = true, readOnly = true)
    public int getId() {
        return Id;
    }

    public void setId(int id) {
        this.Id = id;
    } 

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        this.Nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellidos(String apellido) {
        this.Apellido = apellido;
    }

    public Date getFechaNacimiento() {
        return FechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.FechaNacimiento = fechaNacimiento;
    } 

    public int getEdad() {
        //return Edad;

        if (this.Edad == 0)
        {
            
            LocalDate localdate = this.FechaNacimiento.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            return Period.between(localdate, LocalDate.now()).getYears();            
        }
        else{
            return Edad;
        }
    }

    public void setEdad(int edad) {
        this.Edad = edad;        
    }       

    @ApiModelProperty(hidden = true,readOnly = true)
    public Date getFechaProbableMuerte() {
        return fechaProbableMuerte;
    }

    public void setFechaProbableMuerte(Date fechaProbableMuerte) {
        this.fechaProbableMuerte = fechaProbableMuerte;
    }
}
