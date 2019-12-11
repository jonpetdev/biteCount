package com.app.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name="limitai")
public class LimitsBite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Float skambLT;
    private Float skambUZ;
    private Float smsLT;
    private Float smsUZ;
    private Float internetas;
    private Float kitos;
    private Float stovejimas;



    public LimitsBite(){}

    public LimitsBite(Float skambLT, Float skambUZ, Float smsLT, Float smsUz, Float internetas, Float kitos, Float stovejimas){
        this.skambLT=skambLT;
        this.skambUZ=skambUZ;
        this.smsLT=smsLT;
        this.smsUZ=smsUz;
        this.internetas=internetas;
        this.kitos=kitos;
        this.stovejimas=stovejimas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getSkambLT() {
        return skambLT;
    }

    public void setSkambLT(Float skambLT) {
        this.skambLT = skambLT;
    }

    public Float getSkambUZ() {
        return skambUZ;
    }

    public void setSkambUZ(Float skambUZ) {
        this.skambUZ = skambUZ;
    }

    public Float getSmsLT() {
        return smsLT;
    }

    public void setSmsLT(Float smsLT) {
        this.smsLT = smsLT;
    }

    public Float getSmsUZ() {
        return smsUZ;
    }

    public void setSmsUZ(Float smsUZ) {
        this.smsUZ = smsUZ;
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

    public Float getStovejimas() {
        return stovejimas;
    }

    public void setStovejimas(Float stovejimas) {
        this.stovejimas = stovejimas;
    }


}
