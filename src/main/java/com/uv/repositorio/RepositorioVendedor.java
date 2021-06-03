package com.uv.repositorio;

import com.uv.modelo.Vendedor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioVendedor extends JpaRepository<Vendedor, Long> {

    public boolean existsByUsername(String username);

    public Vendedor findByUsername(String username);
}
