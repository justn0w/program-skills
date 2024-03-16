package com.justnow.skills._01_generics.typeclass;

import com.justnow.core.domain.model.Programmer;
import com.justnow.core.domain.requst.ProgrammerQueryRequest;

import java.util.Arrays;
import java.util.List;

public class CommonServiceImpl implements CommonService{
    @Override
    public CommonResult<List<Programmer>> queryAllProgrammerList(ProgrammerQueryRequest request) {
        CommonResult commonResult = new CommonResult();
        List<Programmer> lists = Arrays.asList(new Programmer("justNow", Boolean.TRUE, 3), new Programmer("justNow2", Boolean.TRUE, 3));

        commonResult.setValue(lists);

        return commonResult;

    }

    @Override
    public CommonResult<Programmer> queryProgrammerById(Long id) {
        CommonResult commonResult = new CommonResult();
        Programmer justnow2 = new Programmer("justnow2", Boolean.TRUE, 1);

        commonResult.setValue(justnow2);

        return commonResult;
    }
}
