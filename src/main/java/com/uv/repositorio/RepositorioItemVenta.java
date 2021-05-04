package com.uv.repositorio;

import com.uv.modelo.ItemVenta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioItemVenta extends JpaRepository<ItemVenta, Long> {
}
