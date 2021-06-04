package com.uv.repositorio;

import com.uv.modelo.Proveedor;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RepositorioProveedor extends JpaRepository<Proveedor, Long> {

    @Query(value = "select p "
            + "from Proveedor p where p.activo = 1")
    public List<Proveedor> findByActivo();
}
