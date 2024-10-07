package com.design.patterns.abstract_factory_ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.design.patterns.abstract_factory_ecommerce.domains.Product;
import com.design.patterns.abstract_factory_ecommerce.repositories.ProductDAO;

@Service
public class ProductService {
    private final ProductDAO productDAO;

    @Autowired
    public ProductService(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    public void agregarProducto(Product producto) {
        // Llama a la capa de acceso a datos para agregar un nuevo producto
        productDAO.agregarProducto(producto);
    }

    public List<Product> obtenerProductos() {
        // Llama a la capa de acceso a datos para obtener los productos
        return productDAO.obtenerProductos();
    }

    public Product actualizarProducto(Long id, Product producto) {
        // Llama a la capa de acceso a datos para actualizar un producto
        return productDAO.actualizarProducto(id, producto);
    }

    public void eliminarProducto(Long id) {
        // Llama a la capa de acceso a datos para eliminar un producto
        productDAO.eliminarProducto(id);
    }
}
