package com.justnow.core.domain.requst;

import lombok.Data;

@Data
public class ProgrammerQueryRequest extends BaseRequest{

    private boolean inMiddleAge;

    private boolean systemOwner;

    private Integer childNum;
}
