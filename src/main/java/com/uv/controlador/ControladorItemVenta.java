package com.uv.controlador;

import com.uv.excepcion.RecursoNoEncontrado;
import com.uv.modelo.ItemVenta;
import com.uv.modelo.Venta;
import com.uv.repositorio.RepositorioItemVenta;
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
public class ControladorItemVenta {

    @Autowired
    private RepositorioItemVenta repositorioItemVenta;

    @GetMapping("/itemventas")
    public List<ItemVenta> showAll() {
        return repositorioItemVenta.findAll();
    }

    @GetMapping("/itemventas/{id}")
    public ResponseEntity<ItemVenta> searchById(@PathVariable(value = "id") Long id) throws RecursoNoEncontrado {

        ItemVenta itemVenta = repositorioItemVenta.findById(id).orElseThrow(
                () -> new RecursoNoEncontrado("No se encontró el id: " + id)
        );

        return ResponseEntity.ok().body(itemVenta);

    }
    
    
    @GetMapping("/itemventas/venta")
    public List<ItemVenta> searchByVenta(@RequestParam("venta") Venta idVenta) {
        
        System.out.println(idVenta.toString());
        
        Map<String, String> response = new HashMap<String, String>();
        if (repositorioItemVenta.existsByVenta(idVenta)) {
            
            List<ItemVenta> itemVenta = repositorioItemVenta.findByVenta(idVenta);
            return itemVenta;

        } else {
            response.put("error", "no se encontro la venta solicitada");
            List<ItemVenta> ItemVenta = null;
            return ItemVenta;
        }
        
    }

    @PostMapping("/itemventas")
    public ItemVenta create(@Valid @RequestBody ItemVenta itemVenta) {
        return repositorioItemVenta.save(itemVenta);
    }

    @PutMapping("/itemventas/{id}")
    public ResponseEntity<ItemVenta> update(@PathVariable(value = "id") Long id, @Valid @RequestBody ItemVenta updateItemVenta)
            throws RecursoNoEncontrado {

        ItemVenta itemVenta = repositorioItemVenta.findById(id).orElseThrow(
                () -> new RecursoNoEncontrado("No se encontró el id : " + id)
        );

        itemVenta.setCantidad(updateItemVenta.getCantidad());
        itemVenta.setProducto(updateItemVenta.getProducto());
        itemVenta.setPrecioUnitario(updateItemVenta.getPrecioUnitario());
        itemVenta.setTotal(updateItemVenta.getTotal());

        final ItemVenta itv = repositorioItemVenta.save(itemVenta);
        return ResponseEntity.ok(itv);

    }

    @DeleteMapping("/itemventas/{id}")
    public Map<String, Boolean> delete(@PathVariable(value = "id") Long id) throws RecursoNoEncontrado {

        ItemVenta itemVenta = repositorioItemVenta.findById(id).orElseThrow(
                () -> new RecursoNoEncontrado("No se encontró el id : " + id)
        );

        repositorioItemVenta.delete(itemVenta);
        Map<String, Boolean> respuesta = new HashMap<>();
        respuesta.put("delete", Boolean.TRUE);
        return respuesta;
    }

}
