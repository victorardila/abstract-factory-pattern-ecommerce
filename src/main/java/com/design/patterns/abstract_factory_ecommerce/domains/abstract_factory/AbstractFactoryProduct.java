package com.design.patterns.abstract_factory_ecommerce.domains.abstract_factory;

import java.util.List;

import com.design.patterns.abstract_factory_ecommerce.domains.Product;
import com.design.patterns.abstract_factory_ecommerce.repositories.ProductDAO;

public interface AbstractFactoryProduct {
    ProductDAO createProductDAO();

    List<Product> obtenerProductos();

    void agregarProducto(Product producto);
}
