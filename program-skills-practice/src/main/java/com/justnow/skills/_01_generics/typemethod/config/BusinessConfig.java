package com.justnow.skills._01_generics.typemethod.config;



public class BusinessConfig extends RemoteConfigService {

    private Integer sizeSwitch;

    public Integer getSizeSwitch() {
        return sizeSwitch;
    }

    public void setSizeSwitch(Integer sizeSwitch) {
        this.sizeSwitch = sizeSwitch;
    }
}
