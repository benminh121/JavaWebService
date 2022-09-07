/**
 * It's a REST endpoint that accepts a JSON payload and saves it to the database
 */
package com.clinicals.api.endpoints;

import com.clinicals.api.dto.ClinicalDataRequest;
import com.clinicals.api.model.ClinicalData;
import com.clinicals.api.model.Patient;
import com.clinicals.api.repos.ClinicalDataRepo;
import com.clinicals.api.repos.PatientRepo;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Consumes("application/json")
@Produces("application/json")
@Path("/api")
public class ClinicalDataService {
    @Autowired
    PatientRepo patientRepo;
    @Autowired
    ClinicalDataRepo clinicalDataRepo;

    @Path("/clinicals")
    @POST
    public ClinicalData saveClinicalData(ClinicalDataRequest request) {
        Patient patient = patientRepo.findById(request.getPatientId()).get();
        ClinicalData clinicalData = new ClinicalData();
        clinicalData.setPatient(patient);
        clinicalData.setComponentName(request.getComponentName());
        clinicalData.setComponentValue(request.getComponentValue());
        return clinicalDataRepo.save(clinicalData);
    }
}
