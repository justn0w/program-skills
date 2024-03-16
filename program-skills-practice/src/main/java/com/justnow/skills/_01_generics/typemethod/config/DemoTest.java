package com.justnow.skills._01_generics.typemethod.config;

public class DemoTest {

    public static void main(String[] args) {

        CommonRemoteConfig commonRemoteConfig = ConfigUtil.getConfig(100, CommonRemoteConfig.class);
        BusinessConfig businessConfig = ConfigUtil.getConfig(100, BusinessConfig.class);

        Integer sizeSwitch = businessConfig.getSizeSwitch();



    }
}
