package ssm.blog.util;

import org.apache.shiro.crypto.hash.Md5Hash;

/**
 * Created by Administrator on 2016/12/23 0023.
 */
public class CryptographyUtil {
    public static String md5(String str,String salt){
        //Md5Hash是Shiro中的一个方法
        return new Md5Hash(str,salt).toString();
    }


}
