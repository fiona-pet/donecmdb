package org.onecmdb.utils;

import org.hibernate.boot.Metadata;
import org.hibernate.cfg.JDBCMetaDataConfiguration;
import org.hibernate.cfg.reveng.DefaultReverseEngineeringStrategy;
import org.hibernate.cfg.reveng.ReverseEngineeringSettings;
import org.hibernate.mapping.PersistentClass;
import org.hibernate.mapping.SimpleValue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.onecmdb.TestSmartApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.io.File;

/**
 * Created by tom on 2017/8/22.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = TestSmartApplication.class)
@ComponentScan("org.onecmdb")
@EnableAutoConfiguration
public class HibernateTools {
    private static final String PACKAGE_NAME = "org.onecmdb.entity";
    private static final File outputDir = new File("/work/001_code/github/java/fiona-pet/donecmdb/donecmdb-api/src/main/java/");
    private static final String OVERRIDETEST_REVENG_XML = "overridetest.reveng.xml";
    @Autowired
    private EntityManager entityManager;
    @Test
    @Transactional
    @Rollback(false)
    public void testTools(){
        JDBCMetaDataConfiguration jmdcfg = new JDBCMetaDataConfiguration();



        DefaultReverseEngineeringStrategy c = new IdReverseEngineeringStrategy();
        ReverseEngineeringSettings reverseEngineeringSettings = new ReverseEngineeringSettings(c);

        c.setSettings(reverseEngineeringSettings.setDefaultPackageName(PACKAGE_NAME));
        jmdcfg.setReverseEngineeringStrategy(c);


//        OverrideRepository or = new OverrideRepository();
//        or.addResource(OVERRIDETEST_REVENG_XML);
//
//        jmdcfg.setReverseEngineeringStrategy(or.getReverseEngineeringStrategy(
//                new DefaultReverseEngineeringStrategy() ) );
//
        jmdcfg.readFromJDBC();


        Metadata metadata = jmdcfg.getMetadata();
//        metadata.getIdentifierGenerator()
//
//        Cfg2JavaTool cfg2JavaTool  = new Cfg2JavaTool();
//
//        POJOExporter exporter = new POJOExporter();
//        exporter.setConfiguration(jmdcfg);
//        exporter.getProperties().setProperty("ejb3", "true");
//
//        exporter.setOutputDirectory(outputDir);
//        exporter.start();



        PersistentClass persistentClass = jmdcfg.getMetadata().getEntityBinding(PACKAGE_NAME + ".Orders");
        System.out.println(((SimpleValue)persistentClass.getIdentifier()).getIdentifierGeneratorProperties());
        while (persistentClass.getPropertyIterator().hasNext()){
            Object i = persistentClass.getPropertyIterator().next();
            System.out.println(i.getClass());
        }
//        POJOClass pojoClass = cfg2JavaTool.getPOJOClass(persistentClass);
//
        Orders orders = new Orders();
        orders.setOrderName("test");
//

        JpaRepository jpaRepository = new SimpleJpaRepository<Orders, Long>(Orders.class, entityManager);
//        System.out.println(jpaRepository.findAll());

        jpaRepository.save(orders);




//        Assert.assertNotNull("class not found", classMapping);
//        KeyValue identifier = classMapping.getIdentifier();
//        Assert.assertNotNull(identifier);
    }
}
