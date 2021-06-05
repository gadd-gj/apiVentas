/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uv.controlador;

import com.uv.modelo.Administrador;
import com.uv.modelo.User;
import com.uv.modelo.Vendedor;
import com.uv.repositorio.RepositorioAdministrador;
import com.uv.repositorio.RepositorioVendedor;
import java.util.HashMap;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity findByUsername(@Valid @RequestBody User user) {
        Map<String, String> response = new HashMap<String, String>();

        String username = user.getUsername();
        String password = user.getPassword();

        if (repositorioAdministrador.existsByUsername(username)) {

            Administrador admin = repositorioAdministrador.findByUsername(username);

            if (admin.getPassword().equals(password)) {
                response.put("ok", "1");
                response.put("idUser", String.valueOf(admin.getIdAdministrador()));
            } else {
                response.put("error", "contraseña incorrecta");
            }
            return ResponseEntity.accepted().body(response);

        } else if (repositorioVendedor.existsByUsername(username)) {

            Vendedor vendedor = repositorioVendedor.findByUsername(username);
            if (vendedor.getActivo() == 1) {

                if (vendedor.getPassword().equals(password)) {
                    response.put("ok", "2");
                    response.put("idUser", String.valueOf(vendedor.getIdVendedor()));
                } else {
                    response.put("error", "contraseña incorrecta");
                }
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
