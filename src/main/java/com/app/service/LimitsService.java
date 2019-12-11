package com.app.service;


public interface LimitsService {

    public Boolean skambLTLimitoTik(Float skambLT);

    public Boolean skambUzLimitoTik(Float skambUZ);

    public Boolean smsLTLimitoTik(Float smsLT);

    public Boolean smsUZLimitoTik(Float smsUZ);

    public Boolean internetasLimitoTik(Float internetas);

    public Boolean kitosLimitoTik(Float kitos);

    public Boolean stovejimasLimitoTik(Float stovejimas);
}
