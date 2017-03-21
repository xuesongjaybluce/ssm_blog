package ssm.blog.util;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/3/4 0004.
 */
public class StringUtil {

    public static Boolean isNotEmpty(String param) {
        if (param == "" || param == null) {
            return false;
        }
        return true;
    }

    public static Boolean isEmpty(String param) {
        if (param == "" || param == null) {
            return true;
        }
        return false;
    }

    //String数组转集合
    public static List<String> trainsform(String[] strings) {

        List<String> resultList = new ArrayList<String>();

        for (String l : strings) {
            if (isNotEmpty(l)) {
                resultList.add(l);
            }
        }

        return resultList;
    }
}
