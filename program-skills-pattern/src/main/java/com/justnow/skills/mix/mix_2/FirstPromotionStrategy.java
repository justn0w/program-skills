package com.justnow.skills.mix.mix_2;

import com.justnow.core.domain.Promotion;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * @author justnow
 * Created on 2023-08-06
 * Description
 */


public class FirstPromotionStrategy extends AbstractPromotionStrategy{

    @Override
    protected void doProcess(Promotion promotion) {
        BigDecimal originPrice = promotion.getSalePrice();

        BigDecimal promoPrice = originPrice.multiply(new BigDecimal(promotion.getSkuNum())).multiply(new BigDecimal(0.9));

        System.out.println("第一阶梯促销价为：" + promoPrice);
    }


    @Override
    protected boolean isSupport(Promotion promotion) {
        return Objects.nonNull(promotion) && promotion.getType() == 1 && promotion.getSkuNum() < 10;
    }
}
