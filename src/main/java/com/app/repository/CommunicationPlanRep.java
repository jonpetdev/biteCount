package com.app.repository;

import com.app.model.CommunicationPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommunicationPlanRep extends JpaRepository<CommunicationPlan, Long> {
}
