package com.design.patterns.abstract_factory_ecommerce.domains;

import com.design.patterns.abstract_factory_ecommerce.domains.abstract_factory.AbstractFactory;
import java.util.ArrayList;
import java.util.List;

public class OracleFactory implements AbstractFactory {
    private List<Product> productos = new ArrayList<>();

    @Override
    public List<Product> obtenerProductos() {
        return productos;
    }

    @Override
    public void agregarProducto(Product producto) {
        productos.add(producto);
    }
}