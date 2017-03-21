package ssm.blog.controller;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ssm.blog.entity.Blog;
import ssm.blog.entity.Comment;
import ssm.blog.service.BlogService;
import ssm.blog.service.CommentService;
import ssm.blog.util.ResponseUtil;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by Administrator on 2017/3/10 0010.
 */
@Controller
@RequestMapping("/Comment")
public class CommentController {
    @Resource
    private CommentService commentService;
    @Resource
    private BlogService blogService;

    @RequestMapping("/addComment")
    public void addComment(@RequestParam("blog_id")Integer id,@RequestParam("commentStr") String commentStr, HttpServletResponse response, HttpServletRequest request) throws Exception {

        Comment comment = new Comment();
        comment.setContent(commentStr);
        String userIp = request.getRemoteAddr();
        comment.setUserIp(userIp);
        comment.setBlog_id(id);

        JSONObject result = new JSONObject();
        if(commentService.addComment(comment) > 0){
            Blog blog = blogService.findById(id);
            blog.setReplyHit(blog.getReplyHit() + 1);
            blogService.editBlog(blog);
            result.put("success",true);
        }else{
            result.put("success",false);
        }
        ResponseUtil.write(response,result);
    }

}
