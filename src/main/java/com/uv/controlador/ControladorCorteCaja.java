package com.uv.controlador;

import com.uv.excepcion.RecursoNoEncontrado;
import com.uv.modelo.CorteCaja;
import com.uv.repositorio.RepositorioCorteCaja;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tienda")
public class ControladorCorteCaja {

    @Autowired
    private RepositorioCorteCaja repositorioCorteCaja;
    private static final String MESSAGE = "No se encontró el id: ";

    @GetMapping("/cortecaja")
    public List<CorteCaja> showAll() {
        return repositorioCorteCaja.findAll();
    }

    @GetMapping("/cortecaja/fecha")
    public ResponseEntity<?> searchByFecha(@RequestParam("fecha") @DateTimeFormat(pattern = "dd-MM-yyyy") Date fecha)
            throws RecursoNoEncontrado, ParseException {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String date = simpleDateFormat.format(fecha);

        if (repositorioCorteCaja.existsByFecha(date)) {

            CorteCaja cortecaja = repositorioCorteCaja.findByFecha(date);
            Map<String, Long> response = new HashMap<String, Long>();
            response.put("idCorteCaja", cortecaja.getIdCorteCaja());

            return ResponseEntity.ok().body(response);
        } else {

            Map<String, String> response = new HashMap<String, String>();
            response.put("error", "No se encontro el corte de caja con la fecha: " + date);

            return ResponseEntity.badRequest().body(response);
        }

    }

    @GetMapping("/cortecaja/{id}")
    public ResponseEntity<CorteCaja> searchById(@PathVariable(value = "id") Long id) throws RecursoNoEncontrado {

        CorteCaja corteCaja = repositorioCorteCaja.findById(id).orElseThrow(
                () -> new RecursoNoEncontrado(MESSAGE + id)
        );

        return ResponseEntity.ok().body(corteCaja);
    }

    @PostMapping("/cortecaja")
    public CorteCaja create(@Valid @RequestBody CorteCaja corteCaja) {
        return repositorioCorteCaja.save(corteCaja);
    }

    @PutMapping("/cortecaja/{id}")
    public ResponseEntity<CorteCaja> update(@PathVariable(value = "id") Long id, @Valid @RequestBody CorteCaja updateCorteCaja)
            throws RecursoNoEncontrado {

        CorteCaja corteCaja = repositorioCorteCaja.findById(id).orElseThrow(
                () -> new RecursoNoEncontrado(MESSAGE + id)
        );

        corteCaja.setTotal(updateCorteCaja.getTotal());
        corteCaja.setFecha(updateCorteCaja.getFecha());

        final CorteCaja cc = repositorioCorteCaja.save(corteCaja);
        return ResponseEntity.ok(cc);

    }

    @DeleteMapping("/cortecaja/{id}")
    public Map<String, Boolean> delete(@PathVariable(value = "id") Long id) throws RecursoNoEncontrado {

        CorteCaja corteCaja = repositorioCorteCaja.findById(id).orElseThrow(
                () -> new RecursoNoEncontrado(MESSAGE + id)
        );

        repositorioCorteCaja.delete(corteCaja);
        Map<String, Boolean> respuesta = new HashMap<>();
        respuesta.put("delete", Boolean.TRUE);
        return respuesta;
    }

}
