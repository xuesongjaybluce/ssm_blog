package ssm.blog.realm;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import ssm.blog.entity.Blogger;
import ssm.blog.service.BloggerService;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2016/12/23 0023.
 */
public class MyRealm extends AuthorizingRealm {

    @Resource
    private BloggerService bloggerService;


    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        String username = (String)token.getPrincipal();//获取传递过来的用户名

        Blogger blogger = bloggerService.getByUsername(username);

        if(blogger != null) {
            SecurityUtils.getSubject().getSession().setAttribute("currentUser", blogger);
            AuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                    blogger.getUsername(), blogger.getPassword(), "MyRealm"
            );
            return authenticationInfo;
        }
        else{
            return null;
        }

    }
}
