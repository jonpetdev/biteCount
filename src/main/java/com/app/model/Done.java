package com.app.model;

import javax.persistence.*;


@Entity(name ="vartotojai")
public class Done {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long numeris;
    private String naudotojas;
    private String mokejimoPlanas;
    private String pareigybe;
    private String imone;


    public Done(){

    }

    public Done(Long numeris,String naudotojas, String mokejimoPlanas, String pareigybe, String imone){
            this.numeris=numeris;
            this.naudotojas=naudotojas;
            this.mokejimoPlanas=mokejimoPlanas;
            this.pareigybe=pareigybe;
            this.imone=imone;
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

    public String getNaudotojas() {
        return naudotojas;
    }

    public void setNaudotojas(String naudotojas) {
        this.naudotojas = naudotojas;
    }

    public String getMokejimoPlanas() {
        return mokejimoPlanas;
    }

    public void setMokejimoPlanas(String mokejimoPlanas) {
        this.mokejimoPlanas = mokejimoPlanas;
    }

    public String getPareigybe() {
        return pareigybe;
    }

    public void setPareigybe(String pareigybe) {
        this.pareigybe = pareigybe;
    }

    public String getImone() {
        return imone;
    }

    public void setImone(String imone) {
        this.imone = imone;
    }
}
