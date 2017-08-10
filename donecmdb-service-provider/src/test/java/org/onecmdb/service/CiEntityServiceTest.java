package org.onecmdb.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.onecmdb.TestSmartApplication;
import org.onecmdb.dto.Path;
import org.onecmdb.entity.CiEntity;
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
public class CiEntityServiceTest {
    private static final String alias = "Ci";
    @Autowired
    private CiEntityService ciEntityService;
    @Test
    public void findCi(){
        CiEntity ciEntity = ciEntityService.findCi(new Path<String>(alias));

        Assert.assertNotNull(ciEntity);

        Assert.assertEquals(alias, ciEntity.getAlias());
    }
}
