package com.ben.ws.soap.config;

import javax.xml.ws.Endpoint;
import javax.xml.ws.handler.Handler;
import javax.xml.ws.soap.SOAPBinding;


import com.ben.ws.soap.SiteHandler;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ben.ws.soap.CustomerOrdersWsImpl;

import java.util.ArrayList;

@Configuration
public class WebServiceConfig {
    @Autowired
    private Bus bus;
    @Bean
    public Endpoint endpoint() {
        Endpoint endpoint = new EndpointImpl(bus, new CustomerOrdersWsImpl());
        endpoint.publish("/customerOrdersService");
        SOAPBinding binding = (SOAPBinding) endpoint.getBinding();
        ArrayList<Handler> handlerChain = new ArrayList<>();
        handlerChain.add(new SiteHandler());
        binding.setHandlerChain(handlerChain);
        return endpoint;
    }
}
