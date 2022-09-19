package com.justnow.skills.mock.domain;

import lombok.Data;

/**
 * @author justnow
 * Created on 2022-09-20
 * Description
 */

@Data
public class ParentRequest {

    /**
     * 学生的姓名
     */
    private String studentName;

    /**
     * 学生的年龄
     */
    private int studentAge;
}
