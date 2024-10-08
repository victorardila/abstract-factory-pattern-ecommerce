package com.design.patterns.abstract_factory_ecommerce.controllers;

import com.design.patterns.abstract_factory_ecommerce.domains.Product;
import com.design.patterns.abstract_factory_ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // Endpoint para configurar la base de datos (MySQL u Oracle)
    @PostMapping("/configurarDB")
    public String configurarBaseDatos(@RequestParam String dbType) {
        productService.configureDB(dbType);
        return "Base de datos configurada a: " + dbType;
    }

    // Endpoint para obtener la lista de productos de la base de datos configurada
    @GetMapping
    public List<Product> obtenerProductos() {
        return productService.obtenerProductos();
    }

    // Endpoint para agregar un nuevo producto a la base de datos configurada
    @PostMapping
    public String agregarProducto(@RequestBody Product producto) {
        productService.agregarProducto(producto);
        return "Producto guardado exitosamente en la base de datos simulada: " + productService.getCurrentDB();
    }

    // Endpoint para obtener la base de datos actual en la que se están guardando
    // los productos
    @GetMapping("/dbActual")
    public String obtenerBaseDeDatosActual() {
        String dbActual = productService.getCurrentDB();
        return dbActual != null ? "Guardando productos en la base de datos: " + dbActual
                : "No se ha configurado ninguna base de datos.";
    }

}
