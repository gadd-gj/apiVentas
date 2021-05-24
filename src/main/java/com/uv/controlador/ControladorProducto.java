package com.uv.controlador;

import com.uv.excepcion.RecursoNoEncontrado;
import com.uv.modelo.Producto;
import com.uv.repositorio.RepositorioProducto;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tienda")
public class ControladorProducto {

    @Autowired
    private RepositorioProducto repositorioProducto;

    @GetMapping("/productos")
    public List<Producto> showAll() {
        return repositorioProducto.findAll();
    }

    @GetMapping("/productos/existencias")
    public List<Producto> existencias() {
        return repositorioProducto.findByExistenciaAndActivo();
    }

    @GetMapping("/productos/{id}")
    public ResponseEntity<Producto> searchById(@PathVariable(value = "id") Long id) throws RecursoNoEncontrado {

        Producto producto = repositorioProducto.findById(id).orElseThrow(
                () -> new RecursoNoEncontrado("No se encontró el id : " + id)
        );

        System.out.println("Empresa: " + producto.getProveedor().getEmpresa());
        return ResponseEntity.ok().body(producto);
    }

    @PostMapping("/productos")
    public Producto create(@Valid @RequestBody Producto producto) {
        return repositorioProducto.save(producto);
    }

    @PutMapping("/productos/{id}")
    public ResponseEntity<Producto> update(@PathVariable(value = "id") Long id, @Valid @RequestBody Producto updateProducto)
            throws RecursoNoEncontrado {

        Producto producto = repositorioProducto.findById(id).orElseThrow(
                () -> new RecursoNoEncontrado("No se encontró el id : " + id)
        );

        producto.setNombre(updateProducto.getNombre());
        producto.setCodigo(updateProducto.getCodigo());
        producto.setDescripcion(updateProducto.getDescripcion());
        producto.setPrecio(updateProducto.getPrecio());
        producto.setExistencia(updateProducto.getExistencia());
        producto.setActivo(updateProducto.getActivo());
        producto.setProveedor(updateProducto.getProveedor());

        final Producto p = repositorioProducto.save(producto);
        return ResponseEntity.ok(p);

    }

    @DeleteMapping("/productos/{id}")
    public Map<String, Boolean> delete(@PathVariable(value = "id") Long id) throws RecursoNoEncontrado {

        Producto producto = repositorioProducto.findById(id).orElseThrow(
                () -> new RecursoNoEncontrado("No se encontró el id : " + id)
        );

        repositorioProducto.delete(producto);
        Map<String, Boolean> respuesta = new HashMap<>();
        respuesta.put("delete", Boolean.TRUE);
        return respuesta;
    }

}
