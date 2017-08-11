package org.onecmdb.utils;

import freemarker.cache.StringTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;

import javax.validation.constraints.NotNull;
import java.io.StringWriter;
import java.util.Map;
import java.util.Set;

/**
 * Created by tom on 2017/8/11.
 */
public class StringUtils {
    /**
     * 根据键值对填充字符串，如("hello ${name}",{name:"xiaoming"})
     * 输出：
     * @param content
     * @param map
     * @return
     */
    public static String renderString(String content, Map<String, String> map){
        try {
            StringTemplateLoader stl = new StringTemplateLoader();
            stl.putTemplate("temp", content);


            Configuration cfg = new Configuration(Configuration.VERSION_2_3_25);
            cfg.setTemplateLoader(stl);
            StringWriter writer = new StringWriter();

            Template template = cfg.getTemplate("temp");
            template.process(map, writer);


            return writer.toString();
        }catch (Exception e){
            return content;
        }
    }

    /**
     * 获取表达式中的变量信息
     *
     * @param content
     * @return
     */
    public static Set<String> findVariableNames(@NotNull String content) {
        StringTemplateLoader stl = new StringTemplateLoader();
        stl.putTemplate("temp", content);

        Configuration cfg = new Configuration(Configuration.VERSION_2_3_25);
        cfg.setTemplateLoader(stl);


        return cfg.getSupportedBuiltInNames();
    }
}
