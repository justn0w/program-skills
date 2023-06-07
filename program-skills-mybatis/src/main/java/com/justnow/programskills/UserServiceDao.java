package com.justnow.programskills;

import com.justnow.programskills.domain.UserPO;

/**
 * @author justnow
 * Created on 2023-06-07
 * Description
 */
public interface UserServiceDao {

    public UserPO findUserById(int id);
}
