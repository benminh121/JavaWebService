package com.ben.ws.soap;

import com.ben.ws.trainings.*;
import com.sun.org.apache.xpath.internal.operations.Or;
import org.apache.cxf.feature.Features;

import javax.validation.constraints.Max;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Features(features = "org.apache.cxf.feature.LoggingFeature")
public class CustomerOrdersWsImpl implements CustomerOrdersPortType {
    Map<BigInteger, List<Order>> customerOrders = new HashMap<>();
    int currentId;

    public void init() {
        List<Order> orders = new ArrayList<>();
        Order order = new Order();
        order.setId(BigInteger.valueOf(1));
        Product product = new Product();
        product.setId("1");
        product.setDescription("Iphone");
        product.setQuantity(BigInteger.valueOf(1));
        order.getProduct().add(product);
        orders.add(order);

        customerOrders.put(BigInteger.valueOf(++currentId), orders);
    }

    public CustomerOrdersWsImpl() {
        init();
    }

    @Override
    public GetOrdersResponse getOrders(GetOrdersRequest request) {
        BigInteger customerId = request.getCustomerId();
        List<Order> orders = customerOrders.get(customerId);
        GetOrdersResponse response = new GetOrdersResponse();
        response.getOrder().addAll(orders);
        return response;
    }

    @Override
    public CreateOrdersResponse createOrders(CreateOrdersRequest request) {
        BigInteger customerId = request.getCustomerId();
        Order order = request.getOrder();
        List<Order> orders = customerOrders.get(customerId);
        orders.add(order);
        CreateOrdersResponse response = new CreateOrdersResponse();
        response.setResult(true);

        return null;
    }
}
