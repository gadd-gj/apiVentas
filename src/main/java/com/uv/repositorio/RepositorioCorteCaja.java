package com.uv.repositorio;

import com.uv.modelo.CorteCaja;
import java.util.Date;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioCorteCaja extends JpaRepository<CorteCaja, Long> {

    public boolean existsByFecha(String da);

    public CorteCaja findByFecha(String date);

}
