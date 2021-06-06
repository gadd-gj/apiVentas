package com.uv.repositorio;

import com.uv.modelo.CorteCaja;
import com.uv.modelo.Vendedor;
import com.uv.modelo.Venta;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioVenta extends JpaRepository<Venta, Long> {

    public boolean existsByCorteCaja(CorteCaja idCorteCaja);

    public Venta findByCorteCaja(CorteCaja idCorteCaja);

    public boolean existsByVendedor(Vendedor idVendedor);

    public List<Venta> findByVendedor(Vendedor idVendedor);
}
