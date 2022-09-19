package com.justnow.skills.mock.rpc;

import com.justnow.skills.mock.domain.ParentResponse;
import com.justnow.skills.mock.domain.StudentDo;
import org.springframework.stereotype.Service;

/**
 * @author justnow
 * Created on 2022-09-20
 * Description
 */

@Service
public class DependOnParentRpc {

    public ParentResponse provideService(StudentDo studentDo) {
        ParentResponse parentResponse = new ParentResponse();
        return parentResponse;
    }
}
