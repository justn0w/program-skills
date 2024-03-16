package com.justnow.skills._01_generics.typeclass;

import com.justnow.core.domain.model.Programmer;
import com.justnow.core.domain.requst.ProgrammerQueryRequest;

import java.util.List;

public interface CommonService {

    public CommonResult<List<Programmer>> queryAllProgrammerList(ProgrammerQueryRequest request);

    public CommonResult<Programmer> queryProgrammerById(Long id);
}
