package com.design.patterns.abstract_factory_ecommerce.repositories;

import java.util.ArrayList;
import java.util.List;
import com.design.patterns.abstract_factory_ecommerce.domains.Product;

public class MySQLProductDAOImpl implements ProductDAO {

    // Lista para simular la base de datos MySQL
    private List<Product> productosMySQL = new ArrayList<>();

    @Override
    public List<Product> obtenerProductos() {
        // Simulamos obtener productos desde MySQL
        System.out.println("Obteniendo productos desde MySQL");
        return productosMySQL; // Devolvemos la lista de productos en memoria
    }

    @Override
    public void agregarProducto(Product producto) {
        // Simulamos agregar producto a MySQL
        System.out.println("Guardando producto en MySQL");
        productosMySQL.add(producto); // Añadimos el producto a la lista en memoria
    }

    @Override
    public Product actualizarProducto(Long id, Product producto) {
        // Simulamos actualizar producto en MySQL
        System.out.println("Actualizando producto en MySQL");
        for (int i = 0; i < productosMySQL.size(); i++) {
            if (productosMySQL.get(i).getId().equals(id)) {
                productosMySQL.set(i, producto); // Actualizamos el producto en memoria
                return producto;
            }
        }
        return null; // Si no se encuentra, devolvemos null
    }

    @Override
    public void eliminarProducto(Long id) {
        // Simulamos eliminar producto de MySQL
        System.out.println("Eliminando producto en MySQL");
        productosMySQL.removeIf(producto -> producto.getId().equals(id)); // Eliminamos el producto de la lista
    }
}
