package com.akaz.http.contoller;

import com.akaz.http.models.Products;
import com.akaz.http.services.ProductsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductsController {
    @Autowired
    private ProductsServices productsServices;

    @GetMapping(
            value = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Products findProductById(@PathVariable(value = "id") String id ){
        return productsServices.findProductById(id);
    }

    @GetMapping(
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<Products> findAllProducts(){
        return productsServices.findAllProducts();
    }

    @PostMapping(
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public Products createProduct(
            @RequestBody Products products
    ){
        return productsServices.createProduct(products);
    }

    @PutMapping(
            value = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public Products products(
            @PathVariable(value = "id") String id,
            @RequestBody Products products
    ){
        return productsServices.updateProduct(id, products);
    }

    @DeleteMapping()
    public void deleteProduct(){
        productsServices.deleteProduct();
    }
}
