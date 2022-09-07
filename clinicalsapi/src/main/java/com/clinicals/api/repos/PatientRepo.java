// Creating a repository for the Patient entity.
package com.clinicals.api.repos;

import com.clinicals.api.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepo extends JpaRepository<Patient, Integer> {
}
