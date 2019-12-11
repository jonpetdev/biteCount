package com.app.model;

public class Count {

    private String imone;

    private Float sumaSuPVM;

    public Count(String imone, Float sumaSuPVM){
        this.imone=imone;
        this.sumaSuPVM=sumaSuPVM;
    }

    public String getImone() {
        return imone;
    }

    public void setImone(String imone) {
        this.imone = imone;
    }


    public Float getSumaSuPVM() {
        return sumaSuPVM;
    }

    public void setSumaSuPVM(Float sumaSuPVM) {
        this.sumaSuPVM = sumaSuPVM;
    }
}
