package com.app.service;




import com.app.model.*;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;


public interface DoneFileBaseService {

    public List<DoneFileBase> bitListas(HttpServletRequest request, MultipartFile fileN) throws IOException, InvalidFormatException;

    public Sumos bendraSaskaitosSuma(HttpServletRequest request, MultipartFile fileN) throws IOException, InvalidFormatException;

    public List<Count> sumaImonems(HttpServletRequest request, MultipartFile fileN) throws IOException, InvalidFormatException;

    public Float tikrinam(HttpServletRequest request, GetFromPageBite bite) throws IOException, InvalidFormatException;

    public List<Count> sumaPagal(HttpServletRequest request, MultipartFile fileN) throws IOException, InvalidFormatException;

    public List<Count> sumaPoNuolaidu(HttpServletRequest request, GetFromPageBite bite) throws IOException, InvalidFormatException;

    void multipartFile(HttpServletRequest request, MultipartFile file);
}
