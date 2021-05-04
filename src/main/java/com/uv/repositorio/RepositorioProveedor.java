package com.uv.repositorio;

import com.uv.modelo.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioProveedor extends JpaRepository<Proveedor, Long> {
}
