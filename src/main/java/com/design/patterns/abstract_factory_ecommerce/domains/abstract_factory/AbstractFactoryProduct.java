package com.design.patterns.abstract_factory_ecommerce.domains.abstract_factory;

import java.util.List;

import com.design.patterns.abstract_factory_ecommerce.domains.Product;

public interface AbstractFactoryProduct {
    List<Product> obtenerProductos();

    void agregarProducto(Product producto);
}
