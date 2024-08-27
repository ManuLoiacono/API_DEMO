package com.TP3.demo;

import jakarta.persistence.*;


@Entity
@Table(name = "Usuarios")
public class Usuario {



    @Id
    @SequenceGenerator(name = "usuario_sequence", sequenceName = "usuario_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuario_sequence")
    private Integer id;

    @Column
    private String nombre;

    @Column
    private String trabajo;

    public Usuario() {
    }

    public Usuario(String nombre, String trabajo) {
        this.nombre = nombre;
        this.trabajo = trabajo;
    }

    public Usuario(Integer id, String nombre, String trabajo) {
        this.id = id;
        this.nombre = nombre;
        this.trabajo = trabajo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTrabajo() {
        return trabajo;
    }

    public void setTrabajo(String trabajo) {
        this.trabajo = trabajo;
    }
}
