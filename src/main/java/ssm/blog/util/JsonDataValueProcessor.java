package ssm.blog.util;

import net.sf.json.JsonConfig;
import net.sf.json.processors.DefaultValueProcessor;
import net.sf.json.processors.JsonValueProcessor;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Administrator on 2017/2/24 0024.
 */
public class JsonDataValueProcessor implements JsonValueProcessor{

    private String format;

    public JsonDataValueProcessor(String s){
        this.format = s;
    }
    public Object processArrayValue(Object o, JsonConfig jsonConfig) {
        return process(o);
    }

    public Object processObjectValue(String s, Object o, JsonConfig jsonConfig) {
        return process(o);
    }

    private Object process(Object o){
        if(o instanceof Date){
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format, Locale.CHINESE);
            return simpleDateFormat.format(o);
        }
        return o == null ? "" : o.toString();
    }
}
