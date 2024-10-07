package com.design.patterns.abstract_factory_ecommerce.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.design.patterns.abstract_factory_ecommerce.domains.Product;

@Repository
public class ProductDAOImpl implements ProductDAO {
    private final List<Product> productos = new ArrayList<>(); // Simulación de base de datos

    @Override
    public void agregarProducto(Product producto) {
        // Agrega el producto a la "base de datos"
        productos.add(producto);
    }

    @Override
    public List<Product> obtenerProductos() {
        // Devuelve la lista de productos
        return productos;
    }

    @Override
    public Product actualizarProducto(Long id, Product producto) {
        // Busca el producto por id
        Product productoActualizado = productos.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);

        // Si el producto no existe, devuelve null
        if (productoActualizado == null) {
            return null;
        }

        // Actualiza el producto
        productoActualizado.setNombre(producto.getNombre());
        productoActualizado.setPrecio(producto.getPrecio());
        productoActualizado.setDescripcion(producto.getDescripcion());

        return productoActualizado;
    }

    @Override
    public void eliminarProducto(Long id) {
        // Elimina el producto de la "base de datos"
        productos.removeIf(p -> p.getId().equals(id));
    }
}
