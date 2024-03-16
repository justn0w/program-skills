package com.justnow.core.domain.model;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Programmer {

    private String name;

    private boolean isFather;

    private Integer childNum;
}
