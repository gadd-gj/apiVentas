package com.uv.repositorio;

import com.uv.modelo.ItemVenta;
import com.uv.modelo.Venta;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioItemVenta extends JpaRepository<ItemVenta, Long> {

    public boolean existsByVenta(Venta idVenta);

    public List<ItemVenta> findByVenta(Venta idVenta);
}
