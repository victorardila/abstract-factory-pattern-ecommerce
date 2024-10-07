package com.design.patterns.abstract_factory_ecommerce.repositories;

import java.util.List;
import com.design.patterns.abstract_factory_ecommerce.domains.Product;

public interface ProductDAO {
    // Obtiene la lista de productos
    List<Product> obtenerProductos();

    // Agrega un producto a la "base de datos"
    void agregarProducto(Product producto);

    // Actualiza un producto en la "base de datos"
    Product actualizarProducto(Long id, Product producto);

    // Elimina un producto de la "base de datos"
    void eliminarProducto(Long id);
}
