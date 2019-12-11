package com.app.model;

import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;

@Entity(name="nuolaidos")
public class GetFromPageBite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Float procSaskaita;
    private Float procSkambuciams;
    private Float procSMS;
    private String date;

    @Transient
    private MultipartFile file;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
