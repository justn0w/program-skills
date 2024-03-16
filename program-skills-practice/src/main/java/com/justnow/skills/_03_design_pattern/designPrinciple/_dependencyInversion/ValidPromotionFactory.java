package com.justnow.skills._03_design_pattern.designPrinciple._dependencyInversion;

import com.justnow.core.domain.requst.PromoRequest;


import java.util.Map;

public class ValidPromotionFactory {


    private Map<Integer, ValidHandler> handlerMap;

    public ValidHandler getValidHandler(PromoRequest request) {
        Integer type = request.getType();
        return handlerMap.get(type);
    }

    public Map<Integer, ValidHandler> getHandlerMap() {
        return handlerMap;
    }

    public void setHandlerMap(Map<Integer, ValidHandler> handlerMap) {
        this.handlerMap = handlerMap;
    }
}
