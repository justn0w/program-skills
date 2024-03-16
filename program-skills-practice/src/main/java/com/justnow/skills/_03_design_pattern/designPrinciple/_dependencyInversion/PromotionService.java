package com.justnow.skills._03_design_pattern.designPrinciple._dependencyInversion;

import com.justnow.core.domain.requst.PromoRequest;
import org.springframework.beans.factory.annotation.Autowired;




public class PromotionService {


    @Autowired
    private ValidPromotionFactory validPromotionFactory;

    public void createPromotion(PromoRequest request) {
        //1 对入参的校验

        ValidHandler validHandler = validPromotionFactory.getValidHandler(request);
        validHandler.handle(request);


    }
}
