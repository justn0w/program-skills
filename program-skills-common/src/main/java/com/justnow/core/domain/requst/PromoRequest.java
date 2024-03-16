package com.justnow.core.domain.requst;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PromoRequest {

    private Long id;

    private String name;

    private Integer type;
}
