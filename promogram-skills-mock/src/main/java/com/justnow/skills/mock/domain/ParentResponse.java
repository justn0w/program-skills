package com.justnow.skills.mock.domain;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author justnow
 * Created on 2022-09-20
 * Description
 */
@Data
public class ParentResponse {

    /**
     * 生活费
     */
    private BigDecimal money;

    /**
     * 是否有时间
     */
    private boolean time;

}
