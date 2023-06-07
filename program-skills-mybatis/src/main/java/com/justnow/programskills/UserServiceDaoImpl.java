package com.justnow.programskills;

import com.justnow.programskills.domain.UserPO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * @author justnow
 * Created on 2023-06-07
 * Description
 */

public class UserServiceDaoImpl implements UserServiceDao {

    @Autowired(required = false)
    private SqlSessionTemplate sqlSessionTemplate;

    public UserPO findUserById(int id) {
       return sqlSessionTemplate.selectOne("UserServiceDao.findUserById", id);
    }
}
