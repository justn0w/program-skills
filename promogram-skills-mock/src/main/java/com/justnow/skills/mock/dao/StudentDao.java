package com.justnow.skills.mock.dao;

import com.justnow.skills.mock.domain.StudentDo;
import org.springframework.stereotype.Service;

@Service
public class StudentDao {
    public StudentDo queryStudentById(long id) {
        return new StudentDo();
    }

}
