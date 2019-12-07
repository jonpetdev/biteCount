package com.app.model;

public class DoneFileBase {

    private Long numeris;
    private String mokejimoPlanas;
    private Float menesioMokesčiai;
    private Float nuolaidos;
    private Float automobilioStatymas;
    private Float sumaBePVM;
    private Float sumaSuPVM;


    public DoneFileBase(Long numeris, String mokejimoPlanas, Float menesioMokesčiai, Float nuolaidos, Float automobilioStatymas, Float sumaBePVM, Float sumaSuPVM){
        this.numeris=numeris;
        this.mokejimoPlanas=mokejimoPlanas;
        this.menesioMokesčiai=menesioMokesčiai;
        this.nuolaidos=nuolaidos;
        this.automobilioStatymas=automobilioStatymas;
        this.sumaBePVM=sumaBePVM;
        this.sumaSuPVM=sumaSuPVM;
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

    public Float getMenesioMokesčiai() {
        return menesioMokesčiai;
    }

    public void setMenesioMokesčiai(Float menesioMokesčiai) {
        this.menesioMokesčiai = menesioMokesčiai;
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
}
