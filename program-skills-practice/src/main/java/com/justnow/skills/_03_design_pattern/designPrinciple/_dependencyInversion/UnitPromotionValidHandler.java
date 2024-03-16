package com.justnow.skills._03_design_pattern.designPrinciple._dependencyInversion;

import com.justnow.core.domain.requst.PromoRequest;

public class UnitPromotionValidHandler implements ValidHandler{


    @Override
    public void handle(PromoRequest request) {

        System.out.println("对单品促销进行校验");

    }


}
