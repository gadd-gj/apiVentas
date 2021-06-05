/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uv.controlador;

import com.uv.modelo.Administrador;
import com.uv.modelo.Vendedor;
import com.uv.repositorio.RepositorioAdministrador;
import com.uv.repositorio.RepositorioVendedor;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author gaddiel
 */
@RestController
@RequestMapping("/tienda")
public class ControladorLogin {

    @Autowired
    RepositorioAdministrador repositorioAdministrador;

    @Autowired
    RepositorioVendedor repositorioVendedor;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ResponseEntity findByUsername(@RequestParam("username") String username) {

        Map<String, String> response = new HashMap<String, String>();

        if (repositorioAdministrador.existsByUsername(username)) {

            Administrador admin = repositorioAdministrador.findByUsername(username);
            response.put("ok", "1");
            response.put("idUser", String.valueOf(admin.getIdAdministrador()));
            return ResponseEntity.accepted().body(response);

        } else if (repositorioVendedor.existsByUsername(username)) {

            Vendedor vendedor = repositorioVendedor.findByUsername(username);
            if (vendedor.getActivo() == 1) {
                response.put("ok", "2");
                response.put("idUser", String.valueOf(vendedor.getIdVendedor()));
                return ResponseEntity.accepted().body(response);
            } else {
                response.put("error", "0");
                return ResponseEntity.badRequest().body(response);
            }

        } else {

            response.put("error", "0");
            return ResponseEntity.badRequest().body(response);

        }
    }

}
