package com.hejz;

import com.hejz.dao.UserInfoMapper;
import com.hejz.entity.UserInfo;
import org.apache.jasper.tagplugins.jstl.ForEach;
import org.codehaus.jackson.annotate.JsonSubTypes;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

    @Autowired
    UserInfoMapper userInfoMapper;

    @Test
    public void contextLoads() {
    }

    @Test
    public void  testFind(){
       // UserInfo user = userInfoMapper.findById(1);
        List<UserInfo> list = userInfoMapper.getUserByName("zs");
        for(UserInfo user : list) {
            System.out.println(user);
        }
    }

    @Test
    public void  testFindALL(){
        // UserInfo user = userInfoMapper.findById(1);
        List<UserInfo> list = userInfoMapper.findAll();
        for(UserInfo user : list) {
            System.out.println(user);
        }
    }

}
