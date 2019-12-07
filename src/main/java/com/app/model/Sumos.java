package com.app.model;

public class Sumos {
    private Float bendraSumaBePVM;
    private Float bendraSumaSuPVM;


    public Sumos(Float bendraSumaBePVM, Float bendraSumaSuPVM){
        this.bendraSumaBePVM=bendraSumaBePVM;
        this.bendraSumaSuPVM=bendraSumaSuPVM;
    }


    public Float getBendraSumaBePVM() {
        return bendraSumaBePVM;
    }

    public void setBendraSumaBePVM(Float bendraSumaBePVM) {
        this.bendraSumaBePVM = bendraSumaBePVM;
    }

    public Float getBendraSumaSuPVM() {
        return bendraSumaSuPVM;
    }

    public void setBendraSumaSuPVM(Float bendraSumaSuPVM) {
        this.bendraSumaSuPVM = bendraSumaSuPVM;
    }
}
