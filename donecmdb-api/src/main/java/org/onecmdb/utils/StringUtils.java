package org.onecmdb.utils;

import freemarker.cache.StringTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.StringWriter;
import java.util.Map;

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
            stl.putTemplate("", content);

            Configuration cfg = new Configuration(Configuration.VERSION_2_3_25);
            cfg.setTemplateLoader(stl);

            StringWriter writer = new StringWriter();

            Template template = cfg.getTemplate("");
            template.process(map, writer);

            return writer.toString();
        }catch (Exception e){
            return content;
        }
    }
}
