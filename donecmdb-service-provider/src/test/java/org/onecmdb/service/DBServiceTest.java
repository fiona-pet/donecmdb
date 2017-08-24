package org.onecmdb.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.onecmdb.TestSmartApplication;
import org.onecmdb.dto.ListFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
public class DBServiceTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(DBServiceTest.class);

    @Autowired
    private DBService dbService;

    @Test
    public void list(){
        List result = dbService.list(new ListFilter());

        LOGGER.debug("list:{}", result);
    }
}
