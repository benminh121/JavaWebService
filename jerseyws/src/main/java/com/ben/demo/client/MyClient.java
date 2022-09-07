package com.ben.demo.client;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.Response;

import java.io.UnsupportedEncodingException;

public class MyClient {
    private static void send() throws UnsupportedEncodingException {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://localhost:8080/demo_war_exploded/restapi/hello-world");
        String response = target.request().get(String.class);
        System.out.println(response);
    }
    public static void main(String[] args) {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://localhost:8080/demo_war/restapi/hello-world");
        Response response = target.request("text/plain").get();
        String value = response.readEntity(String.class);
        System.out.println(value);
    }
}
