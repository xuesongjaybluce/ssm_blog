package ssm.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ssm.blog.entity.Blog;
import ssm.blog.entity.Page;
import ssm.blog.service.BlogService;
import ssm.blog.util.StringUtil;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/3/3 0003.
 */
@Controller
@RequestMapping("/")
public class IndexController {

    @Resource
    BlogService blogService;

    @RequestMapping("/index")
    public ModelAndView index(@RequestParam(value = "page", required = false) String page,
                              HttpServletRequest request){

        ModelAndView result = new ModelAndView();
        List<Blog> blogList = null;
        Map limit = new HashMap<String,Integer>();
        //TODO 可以写到配置文件
        int pageSize = 10;
        if(StringUtil.isEmpty(page)){
            page = "1";
        }
        int start = (Integer.parseInt(page) - 1) * pageSize;
        limit.put("start",start);
        limit.put("pageSize",pageSize);
        //取blog总数
        blogList = blogService.listBlog(limit);
        int pageNumber = blogService.countBlog() / pageSize + 1;

        result.addObject("pageNumber",pageNumber);
        result.addObject("page",Integer.parseInt(page));

        result.addObject("blogList",blogList);
        result.setViewName("index");

        return result;
    }
}
