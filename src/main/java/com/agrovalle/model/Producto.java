package com.agrovalle.connect.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Entity
@Table(name = "productos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long agricultorId;

    @Column(nullable = false, length = 100)
    private String tipo;

    @Column(nullable = false)
    private Double cantidadKilos;

    @Column(nullable = false)
    private Double precioPorKilo;

    @Column(nullable = false, length = 100)
    private String municipio;

    @Column(nullable = false)
    private LocalDate fechaCosecha;

    @Column(nullable = false, length = 20)
    private String estado = "DISPONIBLE";
}