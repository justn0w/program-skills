package com.justnow.skills._01_generics.typeclass;

import lombok.Data;

import java.io.Serializable;


@Data
public class CommonResult<T> implements Serializable {

    private boolean success;

    private Integer code;

    private String mess;

    private T value;

    public void failResult(Integer code, String mess) {
        this.success = Boolean.FALSE;
        this.code = code;
        this.mess = mess;
    }
}
