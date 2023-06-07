package com.justnow.programskills;




import com.alibaba.fastjson.JSON;
import com.justnow.programskills.domain.UserPO;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;

/**
 * @author justnow
 * Created on 2023-06-07
 * Description
 */

@Slf4j
public class UserServiceDaoTest extends BaseTest {

    @Autowired
    private UserServiceDao userServiceDao;

    @Test
    public void test01() {

        UserPO resUser = userServiceDao.findUserById(111);

        log.error("result = {}", JSON.toJSONString(resUser));
        System.out.println("a");
    }


}
