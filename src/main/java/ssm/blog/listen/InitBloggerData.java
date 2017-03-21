package ssm.blog.listen;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import ssm.blog.entity.BlogType;
import ssm.blog.entity.Blogger;
import ssm.blog.entity.Link;
import ssm.blog.service.BlogTypeService;
import ssm.blog.service.BloggerService;
import ssm.blog.service.LinkService;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.List;

/**
 * Created by Administrator on 2016/12/26 0026.
 */
@Component
public class InitBloggerData implements ServletContextListener,ApplicationContextAware {

    private static ApplicationContext applicationContext;

    public void contextInitialized(ServletContextEvent servletContextEvent) {
        //获取servlet上下文
        ServletContext servletContext = servletContextEvent.getServletContext();
        //通过applicationContextAware获取spring配置下的BloggerService
        BloggerService bloggerService = (BloggerService)applicationContext.getBean("BloggerService");
        //通过applicationContextAware获取spring配置下的LinkService
        LinkService linkService = (LinkService)applicationContext.getBean("LinkService");
        //获取博主信息
        Blogger blogger = bloggerService.getBloggerData();
        //密码也被获取到了，敏感信息设置为Null
        blogger.setPassword(null);
        //将信息设置到application域中
        servletContext.setAttribute("blogger",blogger);
        //获取链接列表
        List<Link> linkList = linkService.getLinkData();
        //将信息设置到application域中
        servletContext.setAttribute("linkList",linkList);

        //配置博客类别列表
        BlogTypeService blogTypeService = (BlogTypeService)applicationContext.getBean("BlogTypeService");
        List<BlogType> blogTypeList = blogTypeService.listBlogType();
        servletContext.setAttribute("BlogTypeList",blogTypeList);
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {
    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        InitBloggerData.applicationContext = applicationContext;
    }
}
