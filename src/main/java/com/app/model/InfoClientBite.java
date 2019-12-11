package com.app.model;

import javax.persistence.*;

@Entity(name="saskaita")
public class InfoClientBite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long numeris;
    private String date;
    private String imone;
    private String naudotojas;
    private String planas;
    private Float skambLT;
    private Float skambUZ;
    private Float smsLT;
    private Float smsUZ;
    private Float internetas;
    private Float kitos;
    private Float stovejimas;
    private Float sumaSuPVM;


    public InfoClientBite(){}

    public InfoClientBite(Long numeris, String date, String imone, String naudotojas,
                          String planas, Float skambLT, Float skambUZ,
                          Float smsLT, Float smsUZ, Float internetas, Float kitos, Float stovejimas, Float sumaSuPVM){
        this.numeris=numeris;
        this.date=date;
        this.imone=imone;
        this.naudotojas=naudotojas;
        this.planas=planas;
        this.skambLT=skambLT;
        this.skambUZ=skambUZ;
        this.smsLT=smsLT;
        this.smsUZ=smsUZ;
        this.internetas=internetas;
        this.kitos=kitos;
        this.stovejimas=stovejimas;
        this.sumaSuPVM=sumaSuPVM;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNumeris() {
        return numeris;
    }

    public void setNumeris(Long numeris) {
        this.numeris = numeris;
    }

    public String getImone() {
        return imone;
    }

    public void setImone(String imone) {
        this.imone = imone;
    }

    public String getNaudotojas() {
        return naudotojas;
    }

    public void setNaudotojas(String naudotojas) {
        this.naudotojas = naudotojas;
    }

    public String getPlanas() {
        return planas;
    }

    public void setPlanas(String planas) {
        this.planas = planas;
    }

    public Float getSkambLT() {
        return skambLT;
    }

    public void setSkambLT(Float skambLT) {
        this.skambLT = skambLT;
    }

    public Float getSmsLT() {
        return smsLT;
    }

    public void setSmsLT(Float smsLT) {
        this.smsLT = smsLT;
    }

    public Float getInternetas() {
        return internetas;
    }

    public void setInternetas(Float internetas) {
        this.internetas = internetas;
    }

    public Float getKitos() {
        return kitos;
    }

    public void setKitos(Float kitos) {
        this.kitos = kitos;
    }

    public Float getSkambUZ() {
        return skambUZ;
    }

    public void setSkambUZ(Float skambUZ) {
        this.skambUZ = skambUZ;
    }

    public Float getSmsUZ() {
        return smsUZ;
    }

    public void setSmsUZ(Float smsUZ) {
        this.smsUZ = smsUZ;
    }

    public Float getStovejimas() {
        return stovejimas;
    }

    public void setStovejimas(Float stovejimas) {
        this.stovejimas = stovejimas;
    }

    public Float getSumaSuPVM() {
        return sumaSuPVM;
    }

    public void setSumaSuPVM(Float sumaSuPVM) {
        this.sumaSuPVM = sumaSuPVM;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
