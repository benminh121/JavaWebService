package com.ben.restws;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import java.util.List;

@Path("/productservice")
public interface ProductService {
    @GET
    @Path("/products")
    List<Product> getProducts();
    @POST
    @Path("/products")
    long addProduct(Product product);
}