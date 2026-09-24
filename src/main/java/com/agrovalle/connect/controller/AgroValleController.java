package com.agrovalle.connect.controller;

import com.agrovalle.connect.model.Producto;
import com.agrovalle.connect.model.Usuario;
import com.agrovalle.connect.repository.ProductoRepository;
import com.agrovalle.connect.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class AgroValleController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ProductoRepository productoRepository;

    // --- HU-01: Registro de Agricultores ---
    @PostMapping("/auth/register")
    public ResponseEntity<Usuario> registrarAgricultor(@RequestBody Usuario usuario) {
        Usuario nuevoUsuario = usuarioRepository.save(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoUsuario);
    }

    // --- HU-02: Publicación de Productos ---
    @PostMapping("/productos")
    public ResponseEntity<?> publicarProducto(@RequestBody Producto producto) {
        if (producto.getFechaCosecha() != null && producto.getFechaCosecha().isAfter(LocalDate.now())) {
            return ResponseEntity.badRequest().body("La fecha de cosecha no puede ser posterior a hoy.");
        }
        Producto nuevoProducto = productoRepository.save(producto);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoProducto);
    }

    // --- HU-04: Búsqueda y Filtrado por Municipio y Categoría ---
    @GetMapping("/productos/buscar")
    public ResponseEntity<List<Producto>> buscarProductos(
            @RequestParam String municipio, 
            @RequestParam String categoria) {
        // CORREGIDO: Usamos findByMunicipioIgnoreCaseAndTipoIgnoreCase para que coincida con la entidad y el repositorio
        List<Producto> productosFiltrados = productoRepository.findByMunicipioIgnoreCaseAndTipoIgnoreCase(municipio, categoria);
        return ResponseEntity.ok(productosFiltrados);
    }
} 