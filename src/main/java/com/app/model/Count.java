package com.app.model;

public class Count {

    private String imone;
    private Float sumaBePVM;
    private Float sumaSuPVM;

    public Count(String imone, Float sumaBePVM, Float sumaSuPVM){
        this.imone=imone;
        this.sumaBePVM=sumaBePVM;
        this.sumaSuPVM=sumaSuPVM;
    }

    public String getImone() {
        return imone;
    }

    public void setImone(String imone) {
        this.imone = imone;
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
