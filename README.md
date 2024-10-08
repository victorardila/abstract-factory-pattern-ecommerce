# Patron creacional Factoria Abstracta

### Problema

![abstract-factory-e-commerce](https://github.com/user-attachments/assets/b0f4f501-9223-49ff-a350-6bde9b073429)

### Diagrama de clases

![Class_Diagram](https://github.com/user-attachments/assets/b4dfc0bb-2aaf-475c-97fa-7649abb76de1)

### Insomnia

![Insomnia](https://github.com/user-attachments/assets/82557c89-076b-4ade-9a14-aced60914274)

## URI De la aplicacion

```bash
# URI en el puerto 8080
http://localhost:8080
```

## EndPoints del backend

### Configuracion de la base de datos

### `Configurar la base de datos para guardar`

```bash
# POST: Establecer la base de datos puede escoger MySQL o Oracle
http://localhost:8080/api/productos/configurarDB?dbType=MySQL
```

### `Consultar a la base de datos seleccionada`

```bash
# GET: Consultar base de datos actual seleccionada
http://localhost:8080/api/productos/dbActual
```

### `Consultar las bases de datos`

```bash
http://localhost:8080/api/productos/databases
```

### CRUD de la aplicacion

### `Registrar un producto a la base de datos seleccionada`

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

### `Consultar un producto a la base de datos seleccionada`

```bash
# GET
http://localhost:8080/api/productos
```

### `Eliminar registros de la bse de datos seleccionada`

```bash
# DELETE
http://localhost:8080/api/productos
```

### `Eliminar registros de productos cuyos campos esten nulos`

```bash
# DELETE
http://localhost:8080/api/productos/eliminar-nulos
```
