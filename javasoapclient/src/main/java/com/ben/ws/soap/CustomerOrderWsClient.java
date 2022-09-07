package com.ben.ws.soap;

import com.ben.ws.trainings.CustomerOrdersPortType;
import com.ben.ws.trainings.GetOrdersRequest;
import com.ben.ws.trainings.GetOrdersResponse;
import com.ben.ws.trainings.Order;

import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class CustomerOrderWsClient {
    public static void main(String[] args) throws MalformedURLException {
        CustomerOrdersWsImplService service = new CustomerOrdersWsImplService(new URL("http://localhost:8080/wsdlfirstws/customerOrdersService?wsdl"));
        CustomerOrdersPortType customerOrdersWsImplPort = service.getCustomerOrdersWsImplPort();
        GetOrdersRequest request = new GetOrdersRequest();
        request.setCustomerId(BigInteger.valueOf(1));
        GetOrdersResponse response = customerOrdersWsImplPort.getOrders(request);
        List<Order> orders = response.getOrder();
        System.out.println("Number of orders for the customer are: " + orders.size());

    }
}
