package com.justnow.core.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author justnow
 * Created on 2023-08-06
 * Description 总价促销
 */

@Data
@AllArgsConstructor
public class Promotion {

    private int type;

    private int skuNum;

    private BigDecimal salePrice;
}
