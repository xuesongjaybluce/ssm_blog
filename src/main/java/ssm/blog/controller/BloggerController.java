package ssm.blog.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ssm.blog.entity.Blogger;
import ssm.blog.service.BloggerService;
import ssm.blog.util.CryptographyUtil;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;


/**
 * @Description 博主Controller前台部分 不需要认证
 * Created by Administrator on 2016/12/23 0023.
 */
@Controller
@RequestMapping("/blogger")
public class BloggerController {
    @Resource
    private BloggerService bloggerService;

    @RequestMapping("/login")
    public String login(Blogger blogger, HttpServletRequest httpServletRequest){

        Subject subject = SecurityUtils.getSubject();//获取当前登陆的主体
        //将密码使用md5加密
        String newPassword = CryptographyUtil.md5(blogger.getPassword(),blogger.getUsername());
        //封装用户信息，与数据库中查出结果进行匹配
        UsernamePasswordToken token = new UsernamePasswordToken(blogger.getUsername(),newPassword);

        try {
            //会调用MyRealm中的doGetAuthenticationInfo方法进行身份认证
            subject.login(token);
            //验证成功，调到后台主页
            return "redirect:/admin/main.jsp";
        } catch (AuthenticationException e) {
            e.printStackTrace();
            httpServletRequest.setAttribute("blogger",blogger);
            httpServletRequest.setAttribute("errorInfo","用户名或密码错误");
            return "login";     //登录失败，跳回登陆页面并显示错误信息
        }
    }

    public BloggerService getBloggerService() {
        return bloggerService;
    }

    public void setBloggerService(BloggerService bloggerService) {
        this.bloggerService = bloggerService;
    }
}
