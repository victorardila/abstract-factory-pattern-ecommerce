# abstract-factory-pattern-ecommerce

![abstract-factory-e-commerce](https://github.com/user-attachments/assets/b0f4f501-9223-49ff-a350-6bde9b073429)

## URI De la aplicacion

```bash
# URI en el puerto 8080
http://localhost:8080
```

## EndPoints del backend

## Configuracion de la base de datos

## `Consultar a la base de datos seleccionada`

```bash
# GET
http://localhost:8080/api/productos/dbActual
```

## `Configurar la base de datos para guardar`

### Establecer la base de datos

```bash
# POST
http://localhost:8080/api/productos/configurarDB?dbType=MySQL
```

### Consultar la bse de datos establecida

```bash
# GET
http://localhost:8080/api/productos/dbActual
```

## `CRUD productos dependiendo de la base de datos seleccionada`

### Registrar un producto a la base de datos seleccionada

```bash
# POST URI
http://localhost:8080/api/productos
```

```bash
# POST JSON BODY
{
    "name": "Laptop",
    "description": "Intel Core 9, SSD 1024GB, 32 RAM",
    "price": 5600000.00
}
```

### Consultar un producto a la base de datos seleccionada

```bash
# GET
http://localhost:8080/api/productos
```
