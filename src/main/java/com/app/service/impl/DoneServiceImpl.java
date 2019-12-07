package com.app.service.impl;


import com.app.model.Done;
import com.app.repository.DoneRep;
import com.app.service.DoneService;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class DoneServiceImpl implements DoneService {

    @Autowired
    DoneRep doneRep;


    public List<Done> getinam(){
        return doneRep.findAll();
    }



}
