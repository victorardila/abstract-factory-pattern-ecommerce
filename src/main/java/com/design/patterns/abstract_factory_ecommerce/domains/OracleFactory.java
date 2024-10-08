package com.design.patterns.abstract_factory_ecommerce.domains;

import com.design.patterns.abstract_factory_ecommerce.domains.abstract_factory.AbstractFactoryProduct;
import com.design.patterns.abstract_factory_ecommerce.repositories.OracleProductDAOImpl;
import com.design.patterns.abstract_factory_ecommerce.repositories.ProductDAO;

import java.util.ArrayList;
import java.util.List;

public class OracleFactory implements AbstractFactoryProduct {
    private List<Product> productos = new ArrayList<>();

    @Override
    public List<Product> obtenerProductos() {
        return productos;
    }

    @Override
    public void agregarProducto(Product producto) {
        productos.add(producto);
    }

    @Override
    public ProductDAO createProductDAO() {
        return new OracleProductDAOImpl(); // Implementación para Oracle
    }
}