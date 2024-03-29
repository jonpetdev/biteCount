package com.app.repository;



import com.app.model.Done;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoneRep extends JpaRepository<Done, Long> {

    Done findByImone(String imone);

}
