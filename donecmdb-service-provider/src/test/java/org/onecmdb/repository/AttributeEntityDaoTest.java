package org.onecmdb.repository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.onecmdb.TestSmartApplication;
import org.onecmdb.entity.AttributeEntity;
import org.onecmdb.entity.CiEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * 属性信息
 * Created by tom on 2017-03-07 13:25:01.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = TestSmartApplication.class)
@ComponentScan("org.onecmdb")
@EnableAutoConfiguration
public class AttributeEntityDaoTest {

    @Autowired
    private AttributeDao dao;

    @Test
    public void findAll() {
        List<AttributeEntity> entities = dao.findAllBy();

        Assert.assertNotNull(entities);
    }

    @Test
    public void findBy(){
        Long ownerId = 100l;
        String alias = "Ci";

        AttributeEntity entities = dao.findByOwnerIdAndAlias(ownerId, alias);

        Assert.assertNotNull(entities);

    }
}
