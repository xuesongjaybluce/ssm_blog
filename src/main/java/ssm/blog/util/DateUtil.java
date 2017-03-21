package ssm.blog.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2017/3/17 0017.
 */
public class DateUtil {

    /**
     * 日期对象转字符串
     */
    public static String DateToString(Date date,String formate){

        String result = "";
        SimpleDateFormat dateFormat = new SimpleDateFormat(formate);
        if(date != null){
            result = dateFormat.format(date);
        }
        return result;
    }

    /**
     * 字符串转日期
     */
    public static Date StringToDate(String date,String formate ) throws Exception {

        SimpleDateFormat dateFormat = new SimpleDateFormat(formate);
        if(date == null || date == ""){
            return null;
        }
        return dateFormat.parse(date);

    }

    public static String getCurrentDateStr()throws Exception{
        Date date=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddhhmmss");
        return sdf.format(date);
    }
}
