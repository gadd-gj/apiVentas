package com.uv.repositorio;

import com.uv.modelo.Vendedor;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RepositorioVendedor extends JpaRepository<Vendedor, Long> {

    @Query(value = "select v "
            + "from Vendedor v where v.activo = 1")
    public List<Vendedor> findByActivo();
    
    public boolean existsByUsername(String username);

    public Vendedor findByUsername(String username);
}
