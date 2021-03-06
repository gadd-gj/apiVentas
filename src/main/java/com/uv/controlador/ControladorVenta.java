package com.uv.controlador;

import com.uv.excepcion.RecursoNoEncontrado;
import com.uv.modelo.CorteCaja;
import com.uv.modelo.Vendedor;
import com.uv.modelo.Venta;
import com.uv.repositorio.RepositorioVenta;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tienda")
public class ControladorVenta {

    @Autowired
    private RepositorioVenta repositorioVenta;

    @GetMapping("/ventas")
    public List<Venta> showAll() {
        return repositorioVenta.findAll();
    }

    @GetMapping("/ventas/{id}")
    public ResponseEntity<Venta> searchById(@PathVariable(value = "id") Long id) throws RecursoNoEncontrado {

        Venta venta = repositorioVenta.findById(id).orElseThrow(
                () -> new RecursoNoEncontrado("No se encontrĂ³ el id: " + id)
        );

        return ResponseEntity.ok().body(venta);

    }

    @GetMapping("/ventas/cortecaja")
    public ResponseEntity<?> searchByCorteCaja(@RequestParam("corteCaja") CorteCaja idCorteCaja) {

        Map<String, String> response = new HashMap<String, String>();
        if (repositorioVenta.existsByCorteCaja(idCorteCaja)) {
            
            Venta venta = repositorioVenta.findByCorteCaja(idCorteCaja);
            return ResponseEntity.ok().body(venta);

        } else {
            response.put("error", "no se encontro la venta solicitada");
            return ResponseEntity.ok().body(response);
        }
        
    }

    @GetMapping("/ventas/vendedor")
     public List<Venta> searchByVendedor(@RequestParam("vendedor") Vendedor idVendedor) {
        
        
        Map<String, String> response = new HashMap<String, String>();
        if (repositorioVenta.existsByVendedor(idVendedor)) {
            
            List<Venta> venta = repositorioVenta.findByVendedor(idVendedor);
            return venta;

        } else {
            response.put("error", "no se encontro el vendedor solicitada");
            List<Venta> venta = null;
            return venta;
        }
        
    }
    
    @PostMapping("/ventas")
    public Venta create(@Valid @RequestBody Venta venta) {
        return repositorioVenta.save(venta);
    }

    @PutMapping("/ventas/{id}")
    public ResponseEntity<Venta> update(@PathVariable(value = "id") Long id, @Valid @RequestBody Venta updateVenta)
            throws RecursoNoEncontrado {

        Venta venta = repositorioVenta.findById(id).orElseThrow(
                () -> new RecursoNoEncontrado("No se encontrĂ³ el id : " + id)
        );

        venta.setFecha(updateVenta.getFecha());
        venta.setCorteCaja(updateVenta.getCorteCaja());
        venta.setVendedor(updateVenta.getVendedor());
        venta.setTotal(updateVenta.getTotal());

        final Venta v = repositorioVenta.save(venta);
        return ResponseEntity.ok(v);

    }

    @DeleteMapping("/ventas/{id}")
    public Map<String, Boolean> delete(@PathVariable(value = "id") Long id) throws RecursoNoEncontrado {

        Venta venta = repositorioVenta.findById(id).orElseThrow(
                () -> new RecursoNoEncontrado("No se encontrĂ³ el id : " + id)
        );

        repositorioVenta.delete(venta);
        Map<String, Boolean> respuesta = new HashMap<>();
        respuesta.put("delete", Boolean.TRUE);
        return respuesta;
    }

}
