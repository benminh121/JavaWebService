package com.ben.restwsclient;

import com.ben.restwsclient.model.Patient;

import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class PatientWSClient {

    public static final String PATIENT_SERVICE_URL = "http://localhost:8080/restws/services/patientservice";
    public static final String PATIENTS = "/patients";

    public static void main (String[] args){
        Client client = ClientBuilder.newClient();
        // Retrieve 
        WebTarget target = client.target(PATIENT_SERVICE_URL).path("/patients").path("/{id}").resolveTemplate("id","123");
        Invocation.Builder request = target.request();
        Patient patient = request.get(Patient.class);
        System.out.println(patient.getId());
        System.out.println(patient.getName());

        // Update
        patient.setName("Ben2");
        WebTarget putTarget = client.target(PATIENT_SERVICE_URL).path("/patients");
        Response updateResponse = putTarget.request().put(Entity.entity(patient, MediaType.APPLICATION_XML));
        System.out.println(updateResponse.getStatus());
        updateResponse.close();

        // Create
        Patient newPatient = new Patient();
        newPatient.setName("Ben3");
        WebTarget postTarget = client.target(PATIENT_SERVICE_URL).path(PATIENTS);
        Patient createdPatient = postTarget.request().post(Entity.entity(newPatient, MediaType.APPLICATION_XML), Patient.class);
        System.out.println("Created patient ID "+createdPatient.getId());

        client.close();
    }
}
