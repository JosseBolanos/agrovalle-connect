package com.agrovalle.connect;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Clase principal de inicio para la aplicación Agrovalle Connect.
 */
@SpringBootApplication
public class AgrovalleConnectApplication {

    /**
     * Constructor protegido para evitar instanciación externa.
     */
    protected AgrovalleConnectApplication() {
    }

    /**
     * Punto de entrada principal de la aplicación.
     *
     * @param args argumentos de línea de comandos.
     */
    public static void main(final String[] args) {
        SpringApplication.run(AgrovalleConnectApplication.class, args);
    }
}