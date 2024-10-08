package com.design.patterns.abstract_factory_ecommerce.service;

import com.design.patterns.abstract_factory_ecommerce.domains.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    // Simulamos las "bases de datos" con listas en memoria
    private List<Product> productosMySQL = new ArrayList<>();
    private List<Product> productosOracle = new ArrayList<>();
    private String currentDB;

    // Lista de bases de datos disponibles
    private List<String> databases = new ArrayList<>();

    // Constructor
    public ProductService() {
        databases.add("MySQL");
        databases.add("Oracle");
    }

    // Método para obtener las bases de datos disponibles
    public List<String> obtenerBasesDeDatos() {
        return databases;
    }

    // Configurar la base de datos (simulada)
    public void configureDB(String dbType) {
        if (dbType.equalsIgnoreCase("MySQL")) {
            currentDB = "MySQL";
        } else if (dbType.equalsIgnoreCase("Oracle")) {
            currentDB = "Oracle";
        } else {
            throw new IllegalArgumentException("Tipo de base de datos no soportado: " + dbType);
        }
    }

    // Limpiar la base de datos actual
    public void clearDB() {
        if (currentDB == null) {
            throw new IllegalStateException("Base de datos no configurada.");
        }

        if (currentDB.equals("MySQL")) {
            productosMySQL.clear();
        } else if (currentDB.equals("Oracle")) {
            productosOracle.clear();
        } else {
            throw new IllegalStateException("Base de datos desconocida.");
        }
    }

    // Obtener la base de datos actual
    public String getCurrentDB() {
        return currentDB;
    }

    // Agregar producto según la base de datos configurada
    public void agregarProducto(Product producto) {
        if (currentDB == null) {
            throw new IllegalStateException("Base de datos no configurada.");
        }

        if (currentDB.equals("MySQL")) {
            productosMySQL.add(producto);
        } else if (currentDB.equals("Oracle")) {
            productosOracle.add(producto);
        } else {
            throw new IllegalStateException("Base de datos desconocida.");
        }
    }

    // Obtener productos según la base de datos configurada
    public List<Product> obtenerProductos() {
        if (currentDB == null) {
            throw new IllegalStateException("Base de datos no configurada.");
        }

        if (currentDB.equals("MySQL")) {
            return productosMySQL;
        } else if (currentDB.equals("Oracle")) {
            return productosOracle;
        } else {
            throw new IllegalStateException("Base de datos desconocida.");
        }
    }

    // Actualizar un registro por ID guardado en una base de datos
    public void actualizarProducto(Long id, Product producto) {
        if (currentDB == null) {
            throw new IllegalStateException("Base de datos no configurada.");
        }

        if (currentDB.equals("MySQL")) {
            productosMySQL.stream().filter(p -> p.getId().equals(id)).forEach(p -> {
                p.setNombre(producto.getNombre());
                p.setPrecio(producto.getPrecio());
            });
        } else if (currentDB.equals("Oracle")) {
            productosOracle.stream().filter(p -> p.getId().equals(id)).forEach(p -> {
                p.setNombre(producto.getNombre());
                p.setPrecio(producto.getPrecio());
            });
        } else {
            throw new IllegalStateException("Base de datos desconocida.");
        }
    }

    // Obtener un producto por su ID
    public Product obtenerProductoPorId(int id) {
        if (currentDB == null) {
            throw new IllegalStateException("Base de datos no configurada.");
        }

        if (currentDB.equals("MySQL")) {
            return productosMySQL.stream().filter(producto -> producto.getId() == id).findFirst().orElse(null);
        } else if (currentDB.equals("Oracle")) {
            return productosOracle.stream().filter(producto -> producto.getId() == id).findFirst().orElse(null);
        } else {
            throw new IllegalStateException("Base de datos desconocida.");
        }
    }

    // Eliminar todos los registros guardados en una base de datos
    public void eliminarProductos() {
        if (currentDB == null) {
            throw new IllegalStateException("Base de datos no configurada.");
        }

        if (currentDB.equals("MySQL")) {
            productosMySQL.clear();
        } else if (currentDB.equals("Oracle")) {
            productosOracle.clear();
        } else {
            throw new IllegalStateException("Base de datos desconocida.");
        }
    }

    // Eliminar un registro guardado en una base de datos
    public void eliminarProducto(Long id) { // Cambia String a Long
        if (currentDB == null) {
            throw new IllegalStateException("Base de datos no configurada.");
        }

        if (currentDB.equals("MySQL")) {
            productosMySQL.removeIf(producto -> producto.getId().equals(id)); // Cambia == a .equals()
        } else if (currentDB.equals("Oracle")) {
            productosOracle.removeIf(producto -> producto.getId().equals(id)); // Cambia == a .equals()
        } else {
            throw new IllegalStateException("Base de datos desconocida.");
        }
    }

    // Eliminar los productos de la base de datos cuyos valores esten en null
    public void eliminarProductosNulos() {
        if (currentDB == null) {
            throw new IllegalStateException("Base de datos no configurada.");
        }

        if (currentDB.equals("MySQL")) {
            productosMySQL.removeIf(producto -> producto.getNombre() == null || producto.getPrecio() == null);
        } else if (currentDB.equals("Oracle")) {
            productosOracle.removeIf(producto -> producto.getNombre() == null || producto.getPrecio() == null);
        } else {
            throw new IllegalStateException("Base de datos desconocida.");
        }
    }
}
