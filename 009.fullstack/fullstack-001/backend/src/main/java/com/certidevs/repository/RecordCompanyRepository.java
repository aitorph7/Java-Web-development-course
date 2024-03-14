package com.certidevs.repository;

import com.certidevs.model.RecordCompany;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecordCompanyRepository extends JpaRepository<RecordCompany, Long> {
    RecordCompany findByName(String name);
}