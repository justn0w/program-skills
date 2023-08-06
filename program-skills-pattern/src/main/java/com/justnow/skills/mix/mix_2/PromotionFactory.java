package com.justnow.skills.mix.mix_2;

import com.justnow.core.domain.Promotion;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author justnow
 * Created on 2023-08-06
 * Description
 */
public class PromotionFactory{

    @Setter
    private List<AbstractPromotionStrategy> list = new ArrayList<>();

    public AbstractPromotionStrategy getStrategy(Promotion promotion) {
        for (AbstractPromotionStrategy strategy : list) {
            if (strategy.isSupport(promotion)) {
                return strategy;
            }
        }

        return null;
    }
}
