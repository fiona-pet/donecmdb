package org.onecmdb.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.onecmdb.TestSmartApplication;
import org.onecmdb.dto.AttributeDTO;
import org.onecmdb.dto.CiDTO;
import org.onecmdb.dto.Path;
import org.onecmdb.entity.AttributeEntity;
import org.onecmdb.entity.CiEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by tom on 2017/8/10.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = TestSmartApplication.class)
@ComponentScan("org.onecmdb")
@EnableAutoConfiguration
public class ModelServiceTest {
    private static final String alias = "WinXp";
    private static final Logger LOGGER = LoggerFactory.getLogger(ModelServiceTest.class);
    @Autowired
    private ModelService modelService;

    @Test
    public void findCi(){
        List ciEntitys = modelService.list(alias, null);

        Assert.assertNotNull(ciEntitys);
    }

    @Test
    public void list(){
        List<CiDTO> cis = modelService.list(alias, null);

        Assert.assertNotNull(cis);

        LOGGER.debug("alias:{}, list:{}", alias, cis);

    }

    @Test
    public void getById(){
        CiDTO ciDTO = modelService.getCiById(-7048484407295153374l, true);
        LOGGER.debug("ciDTO:{}", ciDTO);
    }
    @Test
    public void create(){
        CiDTO ciDTO = modelService.getCiByPath(new Path<String>(alias));
        LOGGER.debug("create ciDTO:{}", ciDTO);
    }
}
