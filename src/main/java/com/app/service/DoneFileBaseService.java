package com.app.service;




import com.app.model.*;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;


public interface DoneFileBaseService {

    public void mainListas(HttpServletRequest request, GetFromPageBite bite) throws IOException, InvalidFormatException;

    public List<Count> paskirstymas(String date);

    public Float tikrinam(String data);

    public Float nuolaidos(String data);

    public Float bendraPoNuolaidu(List<Count> paskirstymas);

}
