package com.justnow.skills.mock.domain;

import lombok.Data;

/**
 * @author justnow
 * Created on 2022-09-20
 * Description
 */


@Data
public class StudentDo {

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 性别
     */
    private String gender;

    /**
     * 住址
     */
    private String address;

    /**
     * 学生号
     */
    private long studentId;
}
