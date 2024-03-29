package com.akaz.http.services;

import com.akaz.http.models.Products;
import org.springframework.stereotype.Service;

import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service // indica que a classe é um objeto gerenciavel pelo spring boot
public class ProductsServices {

    private Logger logger =  Logger.getLogger(ProductsServices.class.getName()); // retorna uma mensagem personalizada atraves do terminal
    private final AtomicLong counter = new AtomicLong(); // cria uma varivel com padrão atomico. maior segurança

    public Products findProductById(String id){

        logger.info("Buca de produtos por ID - ok");

        Products products = new Products();
        products.setId(counter.incrementAndGet());
        products.setName("Empire");
        products.setBrand("Hinode");
        products.setFeature("Woody");
        products.setPrice(149.99);

        return products;
    }

    public List<Products> findAllProducts(){

        logger.info("Retornando todos os dados - ok");

        List<Products> products = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Products product = mockProducts(i);
            products.add(product);
        }

        return products;
    }

    private Products mockProducts (int i){
        logger.info("Mocando dado - ok");

        Products products = new Products();
        products.setId(counter.incrementAndGet());
        products.setName("Perfume " + i);
        products.setBrand("Brand " + i);
        products.setFeature("Feature " + i);
        products.setPrice(100 + i);

        return products;
    }

    public Products createProduct(Products products){

        logger.info("Criando produto - ok");

        return products;
    }

    public Products updateProduct(String id, Products products){

        logger.info("Atualizando produto - ok");

        Products productId = new Products();
        productId.setId(convertStringInInt(id));


        return productId;
    }

    private Integer convertStringInInt(String id){
        return Integer.parseInt(id);
    }

    public void deleteProduct(){

        logger.info("Excluindo Produto");

    }


}
