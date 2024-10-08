package com.design.patterns.abstract_factory_ecommerce.controllers;

import com.design.patterns.abstract_factory_ecommerce.domains.Product;
import com.design.patterns.abstract_factory_ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    // Endpoint para obtener la base de datos actual en la que se están guardando
    // los productos
    @GetMapping("/dbActual")
    public String obtenerBaseDeDatosActual() {
        String dbActual = productService.getCurrentDB();
        return dbActual != null ? "Guardando productos en la base de datos: " + dbActual
                : "No se ha configurado ninguna base de datos.";
    }

    // Endpoint para obtener la lista de bases de datos disponibles
    @GetMapping("/databases")
    public List<String> getDatabases() {
        return productService.obtenerBasesDeDatos();
    }

    // Endpoint para obtener la lista de productos de la base de datos configurada
    @GetMapping
    public List<Product> obtenerProductos() {
        return productService.obtenerProductos();
    }

    // Obtener productos por ID
    @GetMapping("/{id}")
    public Product obtenerProductoPorId(@PathVariable int id) {
        return productService.obtenerProductoPorId(id);
    }

    // Endpoint para agregar un nuevo producto a la base de datos configurada
    @PostMapping
    public String agregarProducto(@RequestBody Product producto) {
        productService.agregarProducto(producto);
        return "Producto guardado exitosamente en la base de datos simulada: " + productService.getCurrentDB();
    }

    // Endpoint para eliminar todos los productos de la base de datos configurada
    @DeleteMapping
    public ResponseEntity<String> eliminarProductos() {
        productService.eliminarProductos();
        return ResponseEntity.ok("Todos los productos han sido eliminados exitosamente.");
    }

    // Endpoint para eliminar productos cuyos campos estén en null
    @DeleteMapping("/eliminar-nulos")
    public ResponseEntity<String> eliminarProductosNulos() {
        productService.eliminarProductosNulos();
        return ResponseEntity.ok("Productos con campos nulos eliminados exitosamente.");
    }

    // Endpoint para eliminar un producto por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarProductoPorId(@PathVariable Long id) {
        productService.eliminarProducto(id);
        return ResponseEntity.ok("Producto con ID " + id + " eliminado exitosamente.");
    }
}
