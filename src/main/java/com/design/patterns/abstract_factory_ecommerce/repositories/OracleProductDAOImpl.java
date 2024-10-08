package com.design.patterns.abstract_factory_ecommerce.repositories;

import java.util.ArrayList;
import java.util.List;
import com.design.patterns.abstract_factory_ecommerce.domains.Product;

public class OracleProductDAOImpl implements ProductDAO {

    // Lista para simular la base de datos Oracle
    private List<Product> productosOracle = new ArrayList<>();

    @Override
    public List<Product> obtenerProductos() {
        // Simulamos obtener productos desde Oracle
        System.out.println("Obteniendo productos desde Oracle");
        return productosOracle; // Devolvemos la lista de productos en memoria
    }

    @Override
    public void agregarProducto(Product producto) {
        // Simulamos agregar producto a Oracle
        System.out.println("Guardando producto en Oracle");
        productosOracle.add(producto); // Añadimos el producto a la lista en memoria
    }

    @Override
    public Product actualizarProducto(Long id, Product producto) {
        // Simulamos actualizar producto en Oracle
        System.out.println("Actualizando producto en Oracle");
        for (int i = 0; i < productosOracle.size(); i++) {
            if (productosOracle.get(i).getId().equals(id)) {
                productosOracle.set(i, producto); // Actualizamos el producto en memoria
                return producto;
            }
        }
        return null; // Si no se encuentra, devolvemos null
    }

    @Override
    public void eliminarProducto(Long id) {
        // Simulamos eliminar producto de Oracle
        System.out.println("Eliminando producto en Oracle");
        productosOracle.removeIf(producto -> producto.getId().equals(id)); // Eliminamos el producto de la lista
    }
}
