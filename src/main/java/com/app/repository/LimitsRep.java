package com.app.repository;

import com.app.model.LimitsBite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LimitsRep extends JpaRepository<LimitsBite,Long> {

}
