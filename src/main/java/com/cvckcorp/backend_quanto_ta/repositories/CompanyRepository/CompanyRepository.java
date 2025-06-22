package com.cvckcorp.backend_quanto_ta.repositories.CompanyRepository;

import com.cvckcorp.backend_quanto_ta.domain.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {
}
