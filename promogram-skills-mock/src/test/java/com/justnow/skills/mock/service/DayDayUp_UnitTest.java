package com.justnow.skills.mock.service;

import com.google.common.collect.Sets;
import com.justnow.skills.mock.dao.StudentDao;
import com.justnow.skills.mock.domain.ParentResponse;
import com.justnow.skills.mock.domain.StudentDo;
import com.justnow.skills.mock.rpc.DependOnParentRpc;
import com.justnow.skills.mock.utils.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.util.HashSet;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

/**
 * @author justnow
 * Created on 2022-09-20
 * Description
 */
@RunWith(MockitoJUnitRunner.class)
public class DayDayUp_UnitTest {

    @Mock
    private StudentDao studentDao;

    @Mock
    private DependOnParentRpc dependOnParentRpc;

    @InjectMocks
    private DayDayUp dayDayUp;

//    @Before
//    public void init() {
//        MockitoAnnotations.initMocks(DayDayUp_UnitTest.class);
//    }

    @Test
    public void testGetHighScore() {
        //1 构造待测方法的入参
        StudentDo studentDo = new StudentDo();

        //2 打桩

        //mock dao层
        StudentDo studentDo1 = new StudentDo();
        studentDo1.setAge(100);

        Mockito.when(studentDao.queryStudentById(Mockito.anyLong())).thenReturn(studentDo1);

        //mock rpc
        ParentResponse parentResponse = new ParentResponse();
        parentResponse.setMoney(new BigDecimal(10000000));
        Mockito.when(dependOnParentRpc.provideService(Mockito.any())).thenReturn(parentResponse);

        //mock 静态方法
        HashSet<String> setResult = Sets.newHashSet("a", "c");
        MockedStatic stringUtilsMockedStatic = Mockito.mockStatic(StringUtils.class);
        stringUtilsMockedStatic.when(() -> {
           StringUtils.splitStr(Mockito.anyString(), Mockito.anyString());
        }).thenReturn(setResult);

        //mock 同一个类中的方法
        DayDayUp dayDayUpSpy = spy(dayDayUp);
        Mockito.doReturn(true).when(dayDayUpSpy).inMethod(Mockito.anyInt());

        //3 执行方法
        dayDayUpSpy.getHighScore(studentDo);
    }



}
