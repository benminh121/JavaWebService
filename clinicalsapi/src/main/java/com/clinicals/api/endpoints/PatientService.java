/**
 * It's a RESTful web service that exposes the following endpoints:
 * POST /api/patients
 * GET /api/patients/{id}
 * GET /api/patients
 * GET /api/patients/analyze/{id}
 */
package com.clinicals.api.endpoints;

import com.clinicals.api.model.ClinicalData;
import com.clinicals.api.model.Patient;
import com.clinicals.api.repos.PatientRepo;
import org.apache.cxf.rs.security.cors.CrossOriginResourceSharing;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import java.util.ArrayList;
import java.util.List;

@Consumes("application/json")
@Produces("application/json")
@Path("/api")
@CrossOriginResourceSharing(allowAllOrigins = true)
public class PatientService {
    @Autowired
    PatientRepo repo;
    @Path("/patients")
    @POST
    public Patient createPatient(Patient patient){
        return repo.save(patient);
    }
    @Path("/patients/{id}")
    @GET
    public Patient getPatient(@PathParam("id") int id){
        return repo.findById(id).get();
    }

    @Path("/patients")
    @GET
    public List<Patient> getPatients(){
        return repo.findAll();
    }

    @Path("/patients/analyze/{id}")
    @GET
    public Patient analyze(@PathParam("id")int id){
        Patient patient = repo.findById(id).get();
        List<ClinicalData> clinicalData = new ArrayList<>(patient.getClinicalData());
        for(ClinicalData eachEntry : clinicalData){
            if(eachEntry.getComponentName().equals("hw")){
                String[] heightAndWeight = eachEntry.getComponentValue().split("/");
                String height = heightAndWeight[0];
                String weight = heightAndWeight[1];
                float heightInMeters = Float.parseFloat(height) * 0.4536F;
                Float bmi = Float.parseFloat(weight) / (heightInMeters * heightInMeters);
                ClinicalData bmiData = new ClinicalData();
                bmiData.setComponentName("bmi");
                bmiData.setComponentValue(bmi.toString());
                patient.getClinicalData().add(bmiData);
            }
        }
        return patient;
    }
}
