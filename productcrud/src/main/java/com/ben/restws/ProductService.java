package com.ben.restws;

import com.ben.restws.entities.Product;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

@Consumes("application/json")
@Produces("application/json")
@Path("/productservice")
public interface ProductService {

    @Path("/products")
    @GET
    List<Product> getProducts();

    @Path("/products/{id}")
    @GET
    Product getProduct(@PathParam("id") int id);
    @Path("/products")
    @POST
    Response createProduct(Product product);
    @Path("/products")
    @PUT
    Response updateProduct(Product product);
}
