package com.uv.controlador;

import com.uv.excepcion.RecursoNoEncontrado;
import com.uv.modelo.Proveedor;
import com.uv.repositorio.RepositorioProveedor;
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
public class ControladorProveedor {

    @Autowired
    private RepositorioProveedor repositorioProveedor;

    @GetMapping("/proveedores")
    public List<Proveedor> showAll() {
        return repositorioProveedor.findAll();
    }

    @GetMapping("/proveedores/{id}")
    public ResponseEntity<Proveedor> searchById(@PathVariable(value = "id") Long id) throws RecursoNoEncontrado {

        Proveedor proveedor = repositorioProveedor.findById(id).orElseThrow(
                () -> new RecursoNoEncontrado("No se encontró el id : " + id)
        );

        return ResponseEntity.ok().body(proveedor);
    }

    @PostMapping("/proveedores")
    public Proveedor create(@Valid @RequestBody Proveedor proveedor) {
        return repositorioProveedor.save(proveedor);
    }

    @PutMapping("/proveedores/{id}")
    public ResponseEntity<Proveedor> update(@PathVariable(value = "id") Long id, @Valid @RequestBody Proveedor updateProveedor)
            throws RecursoNoEncontrado {

        Proveedor proveedor = repositorioProveedor.findById(id).orElseThrow(
                () -> new RecursoNoEncontrado("No se encontró el id : " + id)
        );

        proveedor.setEmpresa(updateProveedor.getEmpresa());
        proveedor.setTelefono(updateProveedor.getTelefono());

        final Proveedor p = repositorioProveedor.save(proveedor);
        return ResponseEntity.ok(p);

    }

    @DeleteMapping("/proveedores/{id}")
    public Map<String, Boolean> delete(@PathVariable(value = "id") Long id) throws RecursoNoEncontrado {

        Proveedor proveedor= repositorioProveedor.findById(id).orElseThrow(
                () -> new RecursoNoEncontrado("No se encontró el id : " + id)
        );

        repositorioProveedor.delete(proveedor);
        Map<String, Boolean> respuesta = new HashMap<>();
        respuesta.put("delete", Boolean.TRUE);
        return respuesta;
    }

}
