 package com.agrovalle.connect.repository;

import com.agrovalle.connect.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {

    // Búsqueda solo por municipio
    List<Producto> findByMunicipioIgnoreCase(String municipio);

    // Búsqueda combinada por municipio y categoría (Soporte exacto para HU-04)
    List<Producto> findByMunicipioIgnoreCaseAndTipoIgnoreCase(String municipio, String tipo);

}