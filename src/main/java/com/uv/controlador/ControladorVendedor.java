package com.uv.controlador;


import com.uv.excepcion.RecursoNoEncontrado;
import com.uv.modelo.Vendedor;
import com.uv.repositorio.RepositorioVendedor;
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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tienda")
public class ControladorVendedor {

    @Autowired
    private RepositorioVendedor repositorioVendedor;
    private static final String MESSAGE = "No se encontró el id: ";

    @GetMapping("/vendedores")
    public List<Vendedor> showAll() {
        return repositorioVendedor.findAll();
    }

    @GetMapping("/vendedores/{id}")
    public ResponseEntity<Vendedor> searchById(@PathVariable(value = "id") Long id) throws RecursoNoEncontrado {

        Vendedor vendedor = repositorioVendedor.findById(id).orElseThrow(
                () -> new RecursoNoEncontrado(MESSAGE + id)
        );

        return ResponseEntity.ok().body(vendedor);
    }

    @PostMapping("/vendedores")
    public Vendedor create(@Valid @RequestBody Vendedor vendedor) {
        return repositorioVendedor.save(vendedor);
    }

    @PutMapping("/vendedores/{id}")
    public ResponseEntity<Vendedor> update(@PathVariable(value = "id") Long id, @Valid @RequestBody Vendedor updateVendedor)
            throws RecursoNoEncontrado {

        Vendedor vendedor = repositorioVendedor.findById(id).orElseThrow(
                () -> new RecursoNoEncontrado(MESSAGE + id)
        );

        vendedor.setNombre(updateVendedor.getNombre());
        vendedor.setApellidoPaterno(updateVendedor.getApellidoPaterno());
        vendedor.setApellidoMaterno(updateVendedor.getApellidoMaterno());
        vendedor.setUsername(updateVendedor.getUsername());
        vendedor.setPassword(updateVendedor.getPassword());
        vendedor.setActivo(updateVendedor.getActivo());
        vendedor.setAdministrador(updateVendedor.getAdministrador());

        
        
        final Vendedor v = repositorioVendedor.save(vendedor);
        return ResponseEntity.ok(v);

    }
    
    @DeleteMapping("/vendedores/{id}")
    public Map<String, Boolean> delete(@PathVariable(value = "id") Long id) throws RecursoNoEncontrado {

        Vendedor vendedor = repositorioVendedor.findById(id).orElseThrow(
                () -> new RecursoNoEncontrado(MESSAGE + id)
        );

        repositorioVendedor.delete(vendedor);
        Map<String, Boolean> respuesta = new HashMap<>();
        respuesta.put("delete", Boolean.TRUE);
        return respuesta;
    }
    
}
