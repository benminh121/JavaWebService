// Creating a repository for the ClinicalData class.
package com.clinicals.api.repos;

import com.clinicals.api.model.ClinicalData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClinicalDataRepo extends JpaRepository<ClinicalData, Integer> {
}
