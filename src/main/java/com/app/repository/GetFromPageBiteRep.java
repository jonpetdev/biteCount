package com.app.repository;

import com.app.model.GetFromPageBite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GetFromPageBiteRep extends JpaRepository<GetFromPageBite,Long> {

    GetFromPageBite findGetFromPageBiteByDate(String date);

}
