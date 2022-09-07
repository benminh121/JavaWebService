package com.ben.restws;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{
    List<Product> products = new ArrayList<>();
    private long id = 123;

    ProductServiceImpl(){
        Product product = new Product();
        product.setId(++id);
        product.setDescription("My code");
        products.add(product);
    }
    @Override
    public List<Product> getProducts() {
        return products;
    }

    @Override
    public long addProduct(Product product) {
        product.setId(++id);
        products.add(product);
        return product.getId();
    }
}
