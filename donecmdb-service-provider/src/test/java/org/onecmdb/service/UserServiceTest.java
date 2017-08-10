package org.onecmdb.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.onecmdb.TestSmartApplication;
import org.onecmdb.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by tom on 2017/8/10.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = TestSmartApplication.class)
@ComponentScan("org.onecmdb")
@EnableAutoConfiguration
public class UserServiceTest {
    @Autowired
    private UserService userService;
    @Test
    public void getUserByLoginName(){
        User user = userService.getUserByLoginName("root");


        Assert.assertNotNull(user);
    }
}
