package com.app.repository;

import com.app.model.InfoClientBite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InfoClientBiteRep extends JpaRepository<InfoClientBite,Long> {

    List<InfoClientBite> findInfoClientBitesByDateAndImone(String date, String imone);

    List<InfoClientBite> findInfoClientBitesByDate(String date);


}
