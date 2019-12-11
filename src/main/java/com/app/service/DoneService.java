package com.app.service;



import com.app.model.Done;
import java.util.List;

public interface DoneService {

    public List<Done> getinam();

    Done findByImone(String imone);

    Long pagalNR(Long numeris);

}
