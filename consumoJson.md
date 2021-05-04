# Administradores

{
   "nombre":"Juan",
   "apellidoPaterno":"Martinez",
   "apellidoMaterno":"Mendoza",
   "username":"jmm",
   "password":"123"
}


# Vendedores


{
   "nombre":"Jose",
   "apellidoPaterno":"Romero",
   "apellidoMaterno":"Colorado",
   "username":"jrc",
   "password":"1234",
   "administrador": {
        "idAdministrador":1,
        "nombre":"Juan",
        "apellidoPaterno":"Martinez",
        "apellidoMaterno":"Mendoza",
        "username":"jmm",
        "activo":1,
        "password":"1234"
   }
}


# Proveedores

{
    "empresa":"sabritas",
    "telefono":"2711479850"
}



# Productos


{
    "codigo": 1234,
    "nombre": "cheetos",
    "descripcion":"papitas",
    "precio":10.0,
    "existencia":20,
    "activo":1,
    "proveedor":{

        "id": 13,
        "empresa":"sabritas",
        "telefono":"2711479850"
    
    }
}


