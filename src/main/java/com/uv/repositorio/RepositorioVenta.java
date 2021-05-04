package com.uv.repositorio;

import com.uv.modelo.Venta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioVenta extends JpaRepository<Venta, Long> {
}
