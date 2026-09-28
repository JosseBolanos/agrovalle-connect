package com.agrovalle.connect.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "agricultores")
public class Agricultor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre no puede estar vacío")
    @Column(nullable = false)
    private String nombre;

    @NotBlank(message = "La ubicación es obligatoria")
    @Column(nullable = false)
    private String ubicacionValle; // Ejemplo: Dagua, Palmira

    @NotBlank(message = "La cédula es obligatoria")
    @Size(min = 5, max = 15, message = "La cédula debe tener entre 5 y 15 caracteres")
    @Column(nullable = false, unique = true) // Cumple ISO 25010: Evita datos duplicados en PostgreSQL
    private String cedula;

    // Constructor vacío requerido por JPA
    public Agricultor() {}

    // Constructor con parámetros para pruebas y lógica
    public Agricultor(String nombre, String ubicacionValle, String cedula) {
        this.nombre = nombre;
        this.ubicacionValle = ubicacionValle;
        this.cedula = cedula;
    }

    // Métodos Getters y Setters
    public Long getId() { return id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getUbicacionValle() { return ubicacionValle; }
    public void setUbicacionValle(String ubicacionValle) { this.ubicacionValle = ubicacionValle; }
    public String getCedula() { return cedula; }
    public void setCedula(String cedula) { this.cedula = cedula; }
}
