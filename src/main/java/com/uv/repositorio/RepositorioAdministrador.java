package com.uv.repositorio;

import com.uv.modelo.Administrador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioAdministrador extends JpaRepository<Administrador, Long> {

    public boolean existsByUsername(String username);
}
