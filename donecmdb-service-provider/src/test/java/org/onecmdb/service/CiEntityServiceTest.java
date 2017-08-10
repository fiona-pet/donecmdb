package org.onecmdb.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.onecmdb.TestSmartApplication;
import org.onecmdb.dto.ICi;
import org.onecmdb.dto.Path;
import org.onecmdb.entity.AttributeEntity;
import org.onecmdb.entity.CiEntity;
import org.onecmdb.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.asm.Attribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by tom on 2017/8/10.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = TestSmartApplication.class)
@ComponentScan("org.onecmdb")
@EnableAutoConfiguration
public class CiEntityServiceTest {
    private static final String alias = "Ci";
    private static final Logger LOGGER = LoggerFactory.getLogger(CiEntityServiceTest.class);
    @Autowired
    private CiEntityService ciEntityService;

    @Autowired
    private AttributeEntityService attributeEntityService;

    @Test
    public void findCi(){
        CiEntity ciEntity = ciEntityService.findCi(new Path<String>(alias));

        Assert.assertNotNull(ciEntity);

        Assert.assertEquals(alias, ciEntity.getAlias());

        LOGGER.debug("id:{}, ci:{}", ciEntity.getId(), ciEntity);

        List<AttributeEntity> attributeEntitys = attributeEntityService.getAttributesWithAlias(ciEntity.getId(), ciEntity.getAlias());

        LOGGER.debug("attributes:{}", attributeEntitys);
    }
}
