package com.bharath.ws.soap;

import com.bharath.ws.soap.dto.PaymentProcessorRequest;
import com.bharath.ws.soap.dto.PaymentProcessorResponse;
import com.bharath.ws.soap.exceptions.ServiceException;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService(name = "PaymentProcessor")
public interface PaymentProcessor {
    @WebMethod
    public @WebResult(name = "response") PaymentProcessorResponse processPayment(@WebParam(partName = "paymentProcessorRequest") PaymentProcessorRequest paymentProcessorRequest) throws ServiceException;

}
