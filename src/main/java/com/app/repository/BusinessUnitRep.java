package com.app.repository;

import com.app.model.BusinessUnit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusinessUnitRep extends JpaRepository<BusinessUnit, Long> {

}
