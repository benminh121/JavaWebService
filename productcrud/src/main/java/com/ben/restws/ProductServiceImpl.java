package com.ben.restws;

import com.ben.restws.entities.Product;
import com.ben.restws.repos.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.core.Response;
import java.util.List;

public class ProductServiceImpl implements ProductService{

    @Autowired
    ProductRepository repository;
    @Override
    public List<Product> getProducts() {
        return repository.findAll();
    }

    @Override
    public Product getProduct(int id) {
        return repository.findById(id).get();
    }

    @Override
    public Response createProduct(Product product) {
        Product saveProduct = repository.save(product);
        return Response.ok(saveProduct).build();
    }

    @Override
    public Response updateProduct(Product product) {
        Product saveProduct = repository.save(product);
        return Response.ok(saveProduct).build();
    }
}
