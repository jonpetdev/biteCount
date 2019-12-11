package com.app.model;

public class DoneFileBase {

    private Long numeris;
    private String mokejimoPlanas;
    private Float menesioMokesciai;
    private Float skambLT;
    private Float skambUZ;
    private Float smsLT;
    private Float smsUZ;
    private Float internetas;
    private Float kitos;
    private Float nuolaidos;
    private Float automobilioStatymas;
    private Float sumaBePVM;
    private Float sumaSuPVM;


    public DoneFileBase(Long numeris, String mokejimoPlanas, Float menesioMokesciai, Float nuolaidos,
                        Float automobilioStatymas, Float sumaBePVM, Float sumaSuPVM,
                        Float skambLT, Float skambUZ, Float smsLT, Float smsUZ, Float internetas, Float kitos){
        this.numeris=numeris;
        this.mokejimoPlanas=mokejimoPlanas;
        this.menesioMokesciai=menesioMokesciai;
        this.nuolaidos=nuolaidos;
        this.automobilioStatymas=automobilioStatymas;
        this.sumaBePVM=sumaBePVM;
        this.sumaSuPVM=sumaSuPVM;
        this.skambLT=skambLT;
        this.skambUZ=skambUZ;
        this.smsLT=smsLT;
        this.smsUZ=smsUZ;
        this.internetas=internetas;
        this.kitos=kitos;
    }

    public Long getNumeris() {
        return numeris;
    }

    public void setNumeris(Long numeris) {
        this.numeris = numeris;
    }

    public String getMokejimoPlanas() {
        return mokejimoPlanas;
    }

    public void setMokejimoPlanas(String mokejimoPlanas) {
        this.mokejimoPlanas = mokejimoPlanas;
    }

    public Float getMenesioMokesciai() {
        return menesioMokesciai;
    }

    public void setMenesioMokesciai(Float menesioMokesciai) {
        this.menesioMokesciai = menesioMokesciai;
    }

    public Float getNuolaidos() {
        return nuolaidos;
    }

    public void setNuolaidos(Float nuolaidos) {
        this.nuolaidos = nuolaidos;
    }

    public Float getAutomobilioStatymas() {
        return automobilioStatymas;
    }

    public void setAutomobilioStatymas(Float automobilioStatymas) {
        this.automobilioStatymas = automobilioStatymas;
    }

    public Float getSumaBePVM() {
        return sumaBePVM;
    }

    public void setSumaBePVM(Float sumaBePVM) {
        this.sumaBePVM = sumaBePVM;
    }

    public Float getSumaSuPVM() {
        return sumaSuPVM;
    }

    public void setSumaSuPVM(Float sumaSuPVM) {
        this.sumaSuPVM = sumaSuPVM;
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
}
