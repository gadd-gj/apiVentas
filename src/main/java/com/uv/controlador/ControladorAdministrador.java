package com.uv.controlador;

import com.uv.excepcion.RecursoNoEncontrado;
import com.uv.modelo.Administrador;
import com.uv.repositorio.RepositorioAdministrador;
import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/tienda")
public class ControladorAdministrador {

    @Autowired
    private RepositorioAdministrador repositorioAdministrador;
    private static final String MESSAGE = "No se encontró el id: ";

    @GetMapping("/administradores")
    public List<Administrador> showAll() {
        return repositorioAdministrador.findAll();
    }

    @GetMapping("/administradores/{id}")
    public ResponseEntity<Administrador> searchById(@PathVariable(value = "id") Long id) throws RecursoNoEncontrado {

        Administrador administrador = repositorioAdministrador.findById(id).orElseThrow(
                () -> new RecursoNoEncontrado(MESSAGE + id)
        );

        return ResponseEntity.ok().body(administrador);
    }

    @PostMapping("/administradores")
    public Administrador create(@Valid @RequestBody Administrador administrador) {
        return repositorioAdministrador.save(administrador);
    }

    @PutMapping("/administradores/{id}")
    public ResponseEntity<Administrador> update(@PathVariable(value = "id") Long id, @Valid @RequestBody Administrador updateAdministrador)
            throws RecursoNoEncontrado {

        Administrador administrador = repositorioAdministrador.findById(id).orElseThrow(
                () -> new RecursoNoEncontrado(MESSAGE + id)
        );

        administrador.setNombre(updateAdministrador.getNombre());
        administrador.setApellidoPaterno(updateAdministrador.getApellidoPaterno());
        administrador.setApellidoMaterno(updateAdministrador.getApellidoMaterno());
        administrador.setUsername(updateAdministrador.getUsername());
        administrador.setPassword(updateAdministrador.getPassword());

        final Administrador admin = repositorioAdministrador.save(administrador);
        return ResponseEntity.ok(admin);

    }

    @DeleteMapping("/administradores/{id}")
    public Map<String, Boolean> delete(@PathVariable(value = "id") Long id) throws RecursoNoEncontrado {

        Administrador administrador = repositorioAdministrador.findById(id).orElseThrow(
                () -> new RecursoNoEncontrado(MESSAGE + id)
        );

        repositorioAdministrador.delete(administrador);
        Map<String, Boolean> respuesta = new HashMap<>();
        respuesta.put("delete", Boolean.TRUE);
        return respuesta;
    }

}
