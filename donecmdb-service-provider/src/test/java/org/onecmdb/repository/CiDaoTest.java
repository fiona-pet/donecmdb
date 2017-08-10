package org.onecmdb.repository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.onecmdb.TestSmartApplication;
import org.onecmdb.entity.CiEntity;
import org.onecmdb.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * 配置信息
 * Created by tom on 2017-03-07 13:25:01.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = TestSmartApplication.class)
@ComponentScan("org.onecmdb")
@EnableAutoConfiguration
public class CiDaoTest {

    @Autowired
    private CiDao dao;

    @Test
    public void findAll() {
        List<CiEntity> entities = dao.findAllBy();

        Assert.assertNotNull(entities);

    }
}
