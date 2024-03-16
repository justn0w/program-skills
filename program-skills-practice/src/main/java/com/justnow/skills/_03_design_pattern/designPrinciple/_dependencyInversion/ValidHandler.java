package com.justnow.skills._03_design_pattern.designPrinciple._dependencyInversion;

import com.justnow.core.domain.requst.PromoRequest;

public interface ValidHandler {

    public void handle(PromoRequest request);
}
