package utilTest;

import org.junit.Test;
import ssm.blog.util.CryptographyUtil;

/**
 * Created by Administrator on 2016/12/23 0023.
 */

public class CryptographyUtilTest {
    @Test
    public void TestMd5(){
        String password = "123456";
        System.out.println(CryptographyUtil.md5(password,"hello"));
    }

}
