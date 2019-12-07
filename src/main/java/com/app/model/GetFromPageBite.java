package com.app.model;

import org.springframework.web.multipart.MultipartFile;

public class GetFromPageBite {
    private Float procSaskaita;
    private Float procSkambuciams;
    private Float procSMS;
    private MultipartFile file;


    public Float getProcSaskaita() {
        return procSaskaita;
    }

    public void setProcSaskaita(Float procSaskaita) {
        this.procSaskaita = procSaskaita;
    }

    public Float getProcSkambuciams() {
        return procSkambuciams;
    }

    public void setProcSkambuciams(Float procSkambuciams) {
        this.procSkambuciams = procSkambuciams;
    }

    public Float getProcSMS() {
        return procSMS;
    }

    public void setProcSMS(Float procSMS) {
        this.procSMS = procSMS;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
}
