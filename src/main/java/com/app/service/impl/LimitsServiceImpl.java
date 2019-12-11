package com.app.service.impl;


import com.app.model.LimitsBite;
import com.app.repository.LimitsRep;
import com.app.service.LimitsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LimitsServiceImpl implements LimitsService {

    @Autowired
    LimitsRep limitsRep;

    @Override
    public Boolean skambLTLimitoTik(Float skambLT){
        if(limitsRep.findById(3l).get().getSkambLT()>skambLT){
            return true;
        }
        return false;
    }

    @Override
    public Boolean skambUzLimitoTik(Float skambUZ){
        if(limitsRep.findById(3l).get().getSkambUZ()>skambUZ){
            return true;
        }
        return false;
    }

    @Override
    public Boolean smsLTLimitoTik(Float smsLT){
        if(limitsRep.findById(3l).get().getSmsLT()>smsLT){
            return true;
        }
        return false;
    }

    @Override
    public Boolean smsUZLimitoTik(Float smsUZ){
        if(limitsRep.findById(3l).get().getSmsUZ()>smsUZ){
            return true;
        }
        return false;
    }

    @Override
    public Boolean internetasLimitoTik(Float internetas){
        if(limitsRep.findById(3l).get().getInternetas()>internetas){
            return true;
        }
        return false;
    }

    @Override
    public Boolean kitosLimitoTik(Float kitos){
        if(limitsRep.findById(3l).get().getKitos()>kitos){
            return true;
        }
        return false;
    }
    @Override
    public Boolean stovejimasLimitoTik(Float stovejimas){
        if(limitsRep.findById(3l).get().getStovejimas()>stovejimas){
            return true;
        }
        return false;
    }

}
