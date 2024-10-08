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

    // Obtener la base de datos actual
    public String getCurrentDB() {
        return currentDB;
    }
}
