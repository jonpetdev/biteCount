package com.app.service.impl;

import com.app.model.*;
import com.app.repository.DoneRep;
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

    @Override
    public List<DoneFileBase> bitListas(HttpServletRequest request, MultipartFile fileN) throws IOException, InvalidFormatException {
        List<DoneFileBase> bitListas = new ArrayList<>();
        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        String filename = fileN.getOriginalFilename();
        Workbook workbook = WorkbookFactory.create(new File(rootDirectory + "resources/"+filename));
        Sheet sheet = workbook.getSheetAt(0);

        DataFormatter dataFormatter = new DataFormatter();

        for (Row row: sheet) {

            try {

                bitListas.add(new DoneFileBase(
                        Long.parseLong(dataFormatter.formatCellValue(row.getCell(0)).replaceAll(" ","")),
                        dataFormatter.formatCellValue(row.getCell(1)),
                        Float.parseFloat(dataFormatter.formatCellValue(row.getCell(3))),
                        Float.parseFloat(dataFormatter.formatCellValue(row.getCell(16)).replaceAll("-","")),
                        Float.parseFloat(dataFormatter.formatCellValue(row.getCell(18))),
                        Float.parseFloat(dataFormatter.formatCellValue(row.getCell(30))),
                        Float.parseFloat(dataFormatter.formatCellValue(row.getCell(32)))));
            }catch (NumberFormatException e){

            }catch (NullPointerException e){

            }
        }
        return bitListas;
    }

    @Override
    public Sumos bendraSaskaitosSuma(HttpServletRequest request, MultipartFile fileN) throws IOException, InvalidFormatException {
        List<DoneFileBase>bitListas=bitListas(request,fileN);
        Float sumaSuPVM=0.0F;
        Float sumaBePVM=0.0F;

        for(DoneFileBase el: bitListas){
            sumaSuPVM= sumaSuPVM+el.getSumaSuPVM();
            sumaBePVM= sumaBePVM+el.getSumaBePVM();
        }
        return new Sumos(sumaBePVM, sumaSuPVM);
    }

    @Override
    public List<Count> sumaImonems(HttpServletRequest request, MultipartFile fileN) throws IOException, InvalidFormatException {
        List<DoneFileBase>doneFileBaseServiceList= bitListas(request, fileN);

        List<Count> countList=new ArrayList<>();
        boolean taip=false;
        for(DoneFileBase doneFile: doneFileBaseServiceList){
            for(Done done: doneService.getinam()){
                if(doneFile.getNumeris().equals(done.getNumeris()) && taip==false){
                    countList.add(new Count(done.getImone(), doneFile.getSumaBePVM(), doneFile.getSumaSuPVM()));
                    taip=true;
                }
            }
            if(taip==false){
                countList.add(new Count(": Nėra priskirtos įmonės: ",doneFile.getSumaBePVM(),doneFile.getSumaSuPVM()));
            }
            taip=false;

        }
        return countList;
    }

    @Override
    public Float tikrinam(HttpServletRequest request, GetFromPageBite bite) throws IOException, InvalidFormatException {
        List<Count>list=sumaPoNuolaidu(request, bite);
        Float suma=0.0F;
        for(Count el:list){
            suma=suma+el.getSumaSuPVM();
        }
        return suma;
    }

    @Override
    public List<Count> sumaPagal(HttpServletRequest request,MultipartFile fileN) throws IOException, InvalidFormatException {
        List<Count> listCount= sumaImonems(request,fileN);
        List<String> list=new ArrayList<>();

        for(Count count: listCount){
            if(!list.contains(count.getImone())) {
                list.add(count.getImone());

            }
        }

        List<Count> listukas=new ArrayList<>();
        for(String str: list) {
            Float sumaBePVM=0.0F;
            Float sumaSuPVM=0.0F;
            for (Count cc : listCount) {
                if(str.equals(cc.getImone())){
                sumaBePVM=sumaBePVM+cc.getSumaBePVM();
                sumaSuPVM=sumaSuPVM+cc.getSumaSuPVM();
                }
            }
            listukas.add(new Count(str,sumaBePVM,sumaSuPVM));
        }


        return listukas;
    }

    @Override
    public List<Count> sumaPoNuolaidu(HttpServletRequest request, GetFromPageBite bite) throws IOException, InvalidFormatException {
        List<Count> priesNuolaidas=sumaPagal(request, bite.getFile());
        Sumos sumos=bendraSaskaitosSuma(request, bite.getFile());
        List<Count>list=new ArrayList<>();

        Float nuolaidosSuPVM=bite.getProcSaskaita()+bite.getProcSkambuciams()+bite.getProcSMS();
        Float nuolaidosBePVM=nuolaidosSuPVM*0.79F;


        for(Count count:priesNuolaidas){
            float bePVM;
            float suPVM;
            suPVM=nuolaidosSuPVM*((count.getSumaSuPVM()*100)/sumos.getBendraSumaSuPVM())/100;
            suPVM=count.getSumaSuPVM()-suPVM;
            bePVM=nuolaidosBePVM*((count.getSumaBePVM()*100)/sumos.getBendraSumaBePVM())/100;
            bePVM=count.getSumaBePVM()-bePVM;

            list.add(new Count(count.getImone(),bePVM,suPVM));

        }


        return list;
    }


    @Override
    public void multipartFile(HttpServletRequest request, MultipartFile file) {
        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        String filename = file.getOriginalFilename();
        try {
            new File(rootDirectory + "resources/").mkdir();
            byte barr[] = file.getBytes();
            BufferedOutputStream bout = new BufferedOutputStream(new FileOutputStream(rootDirectory + "resources/" + filename));
            bout.write(barr);
            bout.flush();
            bout.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }


}
