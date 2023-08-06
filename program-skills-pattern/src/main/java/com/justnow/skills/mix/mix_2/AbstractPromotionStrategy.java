package com.justnow.skills.mix.mix_2;

import com.justnow.core.domain.Promotion;

/**
 * @author justnow
 * Created on 2023-08-06
 * Description
 */
public abstract class AbstractPromotionStrategy {


    protected abstract boolean isSupport(Promotion promotion);

    protected abstract void doProcess(Promotion promotion);

    public void process(Promotion promotion) {
        doProcess(promotion);
    }
}
