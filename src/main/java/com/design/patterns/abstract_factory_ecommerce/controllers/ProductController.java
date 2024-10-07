package com.design.patterns.abstract_factory_ecommerce.controllers;

import org.springframework.beans.factory.annotation.Autowired;

import com.design.patterns.abstract_factory_ecommerce.domains.Product;
import com.design.patterns.abstract_factory_ecommerce.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product> obtenerProductos() {
        // Llama al servicio para obtener la lista de productos
        return productService.obtenerProductos();
    }

    @PostMapping
    public void agregarProducto(@RequestBody Product producto) {
        // Llama al servicio para agregar un nuevo producto
        productService.agregarProducto(producto);
    }

    @PutMapping("/{id}")
    public Product actualizarProducto(@PathVariable Long id, @RequestBody Product producto) {
        return productService.actualizarProducto(id, producto);
    }

    @DeleteMapping("/{id}")
    public void eliminarProducto(@PathVariable Long id) {
        productService.eliminarProducto(id);
    }
}