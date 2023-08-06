package com.justnow.skills.test.mix;

import com.justnow.core.domain.Promotion;
import com.justnow.skills.mix.mix_2.AbstractPromotionStrategy;
import com.justnow.skills.mix.mix_2.PromotionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;

/**
 * @author justnow
 * Created on 2023-08-06
 * Description
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-config.xml"})
public class TestMix_2 {

    @Autowired
    private PromotionFactory promotionFactory;

    @Test
    public void testDemo() {

        Promotion promotion = new Promotion(1, 100, new BigDecimal(10));
        AbstractPromotionStrategy strategy = promotionFactory.getStrategy(promotion);
        strategy.process(promotion);

        Promotion promotion2 = new Promotion(1, 9, new BigDecimal(10));
        AbstractPromotionStrategy strategy2 = promotionFactory.getStrategy(promotion2);
        strategy.process(promotion2);

    }
}
