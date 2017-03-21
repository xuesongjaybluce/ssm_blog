package ssm.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ssm.blog.entity.Blog;
import ssm.blog.entity.Comment;
import ssm.blog.lucene.BlogIndex;
import ssm.blog.service.BlogService;
import ssm.blog.service.CommentService;
import ssm.blog.util.StringUtil;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by Administrator on 2017/3/8 0008.
 */
@Controller
@RequestMapping("/blog")
public class BlogController {
    @Resource
    private BlogService blogService;
    @Resource
    private CommentService commentService;

    private BlogIndex blogIndex = new BlogIndex();
    @RequestMapping("/hello")
    public void dele(){
        System.out.println("hello");
    }
    @RequestMapping("/article/{id}")
    public ModelAndView blogDetils(@PathVariable("id")Integer id, HttpServletResponse response){

        ModelAndView result = new ModelAndView();
        Blog blog = blogService.findById(id);

        String keyWords = blog.getKeyWord();
        if(StringUtil.isNotEmpty(keyWords)){
            String[] array = keyWords.split(" ");
            //TODO
            List<String> keyWordList = StringUtil.trainsform(array);
            result.addObject("keyWords",keyWordList);
        }else{
            result.addObject("keyWords",null);
        }
        result.addObject("blog",blog);

        List<Comment> commentList = commentService.commentListByBlog(id);
        result.addObject("commentList",commentList);
        result.setViewName("foreground/blog/blogDetils");

        return  result;
    }

    @RequestMapping("/search")
    public ModelAndView search(String search,HttpServletResponse response, HttpServletRequest request){


        ModelAndView result = new ModelAndView();
        List<Blog> blogList = null;
        try {
             blogList = blogIndex.searchIndex(search);
        } catch (Exception e) {
            e.printStackTrace();
        }
        result.addObject("blogList",blogList);
        result.setViewName("foreground/blog/search");

        return result;

    }
}
