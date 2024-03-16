package com.justnow.skills._03_design_pattern_designPrinciple._dependencyInversion;

import com.justnow.core.domain.requst.PromoRequest;
import com.justnow.skills._03_design_pattern.designPrinciple._dependencyInversion.PromotionService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class TestPromotionService extends BaseTest{

    @Autowired
    private PromotionService promotionService;

    @Test
    public void testUnitValid() {
        PromoRequest promoRequest = buildUnitPromoRequest();
        promotionService.createPromotion(promoRequest);
    }


    @Test
    public void testSumValid() {
        PromoRequest promoRequest = buildSumPromoRequest();
        promotionService.createPromotion(promoRequest);
    }


    private PromoRequest buildUnitPromoRequest() {
        return PromoRequest.builder()
                .id(1L)
                .name("单品促销")
                .type(1)
                .build();
    }

    private PromoRequest buildSumPromoRequest() {
        return PromoRequest.builder()
                .id(2L)
                .name("总价促销")
                .type(2)
                .build();
    }
}
