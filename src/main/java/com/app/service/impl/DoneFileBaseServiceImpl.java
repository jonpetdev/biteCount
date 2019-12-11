package com.app.service.impl;

import com.app.model.*;
import com.app.repository.BusinessUnitRep;
import com.app.repository.DoneRep;
import com.app.repository.GetFromPageBiteRep;
import com.app.repository.InfoClientBiteRep;
import com.app.service.DoneFileBaseService;
import com.app.service.DoneService;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;


@Service
public class DoneFileBaseServiceImpl implements DoneFileBaseService {

    @Autowired
    DoneService doneService;

    @Autowired
    DoneRep doneRep;

    @Autowired
    BusinessUnitRep businessUnitRep;

    @Autowired
    InfoClientBiteRep infoClientBiteRep;

    @Autowired
    GetFromPageBiteRep getFromPageBiteRep;

// ----------------bandom tvarkyti visa nesamone parasyta auksciau



    @Override
    public void mainListas(HttpServletRequest request, GetFromPageBite bite) throws IOException, InvalidFormatException {
        List<DoneFileBase> doneBaseListas = new ArrayList<>();
        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        String filename = bite.getFile().getOriginalFilename();
        Workbook workbook = WorkbookFactory.create(new File(rootDirectory + "resources/"+filename));
        Sheet sheet = workbook.getSheetAt(0);

        DataFormatter dataFormatter = new DataFormatter();

        for (Row row: sheet) {

            try {

                doneBaseListas.add(new DoneFileBase(
                        Long.parseLong(dataFormatter.formatCellValue(row.getCell(0)).replaceAll(" ","")),
                        dataFormatter.formatCellValue(row.getCell(1)),
                        Float.parseFloat(dataFormatter.formatCellValue(row.getCell(3))),
                        Float.parseFloat(dataFormatter.formatCellValue(row.getCell(16)).replaceAll("-","")),
                        Float.parseFloat(dataFormatter.formatCellValue(row.getCell(18))),
                        Float.parseFloat(dataFormatter.formatCellValue(row.getCell(30))),
                        Float.parseFloat(dataFormatter.formatCellValue(row.getCell(32))),
                        Float.parseFloat(dataFormatter.formatCellValue(row.getCell(4))),
                        Float.parseFloat(dataFormatter.formatCellValue(row.getCell(9))),
                        Float.parseFloat(dataFormatter.formatCellValue(row.getCell(5))),
                        Float.parseFloat(dataFormatter.formatCellValue(row.getCell(10))),
                        Float.parseFloat(dataFormatter.formatCellValue(row.getCell(8))),
                        Float.parseFloat(dataFormatter.formatCellValue(row.getCell(6)))
                ));
            }catch (NumberFormatException e){

            }catch (NullPointerException e){

            }
        }

        for(DoneFileBase dfb: doneBaseListas){
            Done done = new Done();
            Boolean doneBool=false;
            if(doneService.pagalNR(dfb.getNumeris())!=0L){
                done = doneRep.getOne(doneService.pagalNR(dfb.getNumeris()));
                doneBool = true;
            }

            if(doneBool){
                infoClientBiteRep.save(new InfoClientBite( dfb.getNumeris(),bite.getDate(),done.getImone(), done.getNaudotojas(),
                         done.getMokejimoPlanas(),
                        dfb.getSkambLT(), dfb.getSkambUZ(), dfb.getSmsLT(),
                        dfb.getSmsUZ(), dfb.getInternetas(), dfb.getKitos(), dfb.getAutomobilioStatymas(),
                        dfb.getSumaSuPVM()));
            }else {
                infoClientBiteRep.save(new InfoClientBite( dfb.getNumeris(), bite.getDate(), "Nėra info", "Nėra info",
                        "Nėra info",
                            dfb.getSkambLT(), dfb.getSkambUZ(), dfb.getSmsLT(),
                            dfb.getSmsUZ(), dfb.getInternetas(), dfb.getKitos(), dfb.getAutomobilioStatymas(),
                            dfb.getSumaSuPVM()));
            }

        }

    }

    @Override
    public List<Count> paskirstymas(String date){
        List<Count> counts= new ArrayList<>();

        Float bendraSuma=tikrinam(date);
        Float berdraSuNuolaida=bendraSuma-nuolaidos(date);

        for(BusinessUnit businessUnit: businessUnitRep.findAll()){
            Float suma=0.0f;
            for(InfoClientBite info : infoClientBiteRep.findInfoClientBitesByDateAndImone(date,businessUnit.getName())){
                suma=suma+info.getSumaSuPVM();
            }
            suma=(suma/bendraSuma)*berdraSuNuolaida;
            counts.add(new Count(businessUnit.getName(),suma));
        }

        return counts;
    }

    @Override
    public Float tikrinam(String data){
        Float suma=0.0f;
        for(InfoClientBite info: infoClientBiteRep.findInfoClientBitesByDate(data)){
            suma=suma+info.getSumaSuPVM();
        }
        return suma;
    }

    @Override
    public Float nuolaidos(String data){
         return  getFromPageBiteRep.findGetFromPageBiteByDate(data).getProcSaskaita()+
                 getFromPageBiteRep.findGetFromPageBiteByDate(data).getProcSkambuciams()+
                 getFromPageBiteRep.findGetFromPageBiteByDate(data).getProcSMS();

    }

    @Override
    public Float bendraPoNuolaidu(List<Count> paskirstymas){
        Float suma=0.0f;
        for(Count count:paskirstymas){
            suma=suma+count.getSumaSuPVM();
        }

        return suma;
    }


}
