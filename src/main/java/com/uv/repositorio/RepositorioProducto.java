package com.uv.repositorio;

import com.uv.modelo.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioProducto extends JpaRepository<Producto, Long> {



}
