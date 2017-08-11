package org.onecmdb.utils;

import freemarker.cache.StringTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.Set;

/**
 * Created by tom on 2017/8/11.
 */
public class StringUtilsTest {
    @Test
    public void findVariableNames() throws IOException {
//        Set<String> vars = StringUtils.findVariableNames("hello ${name}");
//
//        Assert.assertNotNull(vars);
//
//        Assert.assertTrue(vars.contains("name"));

        StringTemplateLoader stl = new StringTemplateLoader();
        stl.putTemplate("temp", "hello ${name}");

        Configuration cfg = new Configuration(Configuration.VERSION_2_3_25);
        cfg.setTemplateLoader(stl);

        Template template = cfg.getTemplate("temp");

        System.out.println("getRootTreeNode:" + template.getRootTreeNode().getCanonicalForm());

        System.out.println(stl);

        System.out.println(cfg.getSettingNames(true));
        System.out.println(cfg.getRegisteredCustomOutputFormats());
        System.out.println(cfg.getSharedVariableNames());
        System.out.println(Arrays.toString(cfg.getCustomAttributeNames()));
        System.out.println(cfg.getSupportedBuiltInDirectiveNames());
        System.out.println(cfg.getSupportedBuiltInNames());
        System.out.println(cfg.getRegisteredCustomOutputFormats());
        System.out.println(cfg.getIncompatibleEnhancements());
        System.out.println(template);
        System.out.println(template.getSettingNames(true));
        System.out.println(template.getSourceName());
    }
}
