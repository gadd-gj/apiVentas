package com.uv.repositorio;

import com.uv.modelo.Producto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RepositorioProducto extends JpaRepository<Producto, Long> {

    @Query( value = "select p "
            + "from Producto p where p.existencia <= 10 and p.activo = 1")
    public List<Producto> findByExistenciaAndActivo();

}
