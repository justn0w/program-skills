package com.justnow.skills.mock.service;

import com.justnow.skills.mock.dao.StudentDao;
import com.justnow.skills.mock.domain.ParentResponse;
import com.justnow.skills.mock.domain.StudentDo;
import com.justnow.skills.mock.rpc.DependOnParentRpc;
import com.justnow.skills.mock.utils.StringUtils;

import javax.annotation.Resource;
import java.util.Set;

/**
 * @author justnow
 * Created on 2022-09-20
 * Description
 */
public class DayDayUp {

    @Resource
    private StudentDao studentDao;

    @Resource
    private DependOnParentRpc dependOnParentRpc;

    public void getHighScore(StudentDo studentDo) {

        StudentDo student = studentDao.queryStudentById(studentDo.getStudentId());

        ParentResponse parentResponse = dependOnParentRpc.provideService(student);

        Set<String> splitRes = StringUtils.splitStr("", "a");

        boolean b = inMethod(100);
        System.out.println(b);
    }

    public boolean inMethod(Integer age) {
        System.out.println("I am in Method");
        return false;
    }
}
