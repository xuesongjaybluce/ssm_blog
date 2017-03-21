package ssm.blog.controllerAdmin;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ssm.blog.entity.Blog;
import ssm.blog.entity.Comment;
import ssm.blog.service.BlogService;
import ssm.blog.service.CommentService;
import ssm.blog.util.JsonDataValueProcessor;
import ssm.blog.util.ResponseUtil;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/3/13 0013.
 */
@Controller
@RequestMapping("/admin/comment")
public class CommentAdminController {
    @Resource
    private CommentService commentService;
    @Resource
    private BlogService blogService;

    @RequestMapping("/commentList")
    public void commentList(HttpServletResponse response){

        List<Comment> commentList= commentService.commentListForAudit();
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.registerJsonValueProcessor(Date.class,new JsonDataValueProcessor("yyyy-MM-dd HH:mm"));
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = JSONArray.fromObject(commentList,jsonConfig);

        jsonObject.put("rows",jsonArray);
        try {
            ResponseUtil.write(response,jsonObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/editAudit")
    public void editAudit(@RequestParam(value = "ids",required = false)String ids,@RequestParam(value = "choose",required = false)String choose, HttpServletResponse response){

        String[] idStr = ids.split(",");
        JSONObject jsonObject = new JSONObject();
        //审核结果
        int chooseInt = Integer.parseInt(choose);
        for(int i=0; i < idStr.length; i++){
            int id = Integer.parseInt(idStr[i]);
            Comment comment = commentService.commentById(id);
            if(comment.getBlog() == null && chooseInt == 1){
                jsonObject.put("exist","编号为"+id+"的评论，其博客已经删除，无法通过审核");
            }else{
                comment.setState(chooseInt);
                commentService.editComment(comment);
            }
        }
        jsonObject.put("success",true);
        try {
            ResponseUtil.write(response,jsonObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
