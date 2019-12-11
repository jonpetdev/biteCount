package com.app.model;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public class InfoListUnit {
    private String imone;
    private List<InfoClientBite> listInfo;

    public InfoListUnit(){}

    public InfoListUnit(String imone, List<InfoClientBite> listInfo){
        this.imone=imone;
        this.listInfo=listInfo;
    }

    public String getImone() {
        return imone;
    }

    public void setImone(String imone) {
        this.imone = imone;
    }

    public List<InfoClientBite> getListInfo() {
        return listInfo;
    }

    public void setListInfo(List<InfoClientBite> listInfo) {
        this.listInfo = listInfo;
    }
}
