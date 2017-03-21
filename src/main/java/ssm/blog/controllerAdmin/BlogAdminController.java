package ssm.blog.controllerAdmin;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ssm.blog.entity.Blog;
import ssm.blog.lucene.BlogIndex;
import ssm.blog.service.BlogService;
import ssm.blog.util.JsonDataValueProcessor;
import ssm.blog.util.ResponseUtil;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/2/1 0001.
 */
@Controller
@RequestMapping("/admin/blog")
public class BlogAdminController {
    @Resource
    private BlogService blogService;

    private BlogIndex blogIndex = new BlogIndex();

    //添加博客
    @RequestMapping("/save")
    public void save(Blog blog, HttpServletResponse response) throws Exception {
        int resultTotal = 0;//接受返回结果集总数

        if(blog.getId() == null){
            resultTotal = blogService.addBlog(blog);
            blogIndex.addIndex(blog);//添加索引
        }
        else{
            resultTotal = blogService.editBlog(blog);
        }

        JSONObject jsonObject = new JSONObject();
        if(resultTotal > 0){
            jsonObject.put("success",true);
        }else{
            jsonObject.put("success",false);
        }
        ResponseUtil.write(response,jsonObject);
    }
    @RequestMapping("/listBlog")
    public void listBlog(HttpServletResponse response){
        Map limit = new HashMap<String,Integer>();

        List<Blog> blogList = blogService.listBlog(limit);

        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.registerJsonValueProcessor(Date.class,new JsonDataValueProcessor("yyyy-MM-dd HH:mm"));
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = JSONArray.fromObject(blogList,jsonConfig);

        jsonObject.put("rows",jsonArray);
        try {
            ResponseUtil.write(response,jsonObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/findById")
    public void findById(int id,HttpServletResponse response) throws Exception {

        int resultTotal = 0;
        Blog blog = blogService.findById(id);
        if(blog == null){
            System.out.println(id);
            System.out.println("查找失败");
            return ;
        }
        JSONObject jsonObject = JSONObject.fromObject(blog);

        ResponseUtil.write(response,jsonObject);
    }

    @RequestMapping("/delete")
    public String delete(@RequestParam(value="ids",required=false)String idsStr, HttpServletResponse response){

        String[] idsStrs = idsStr.split(",");

        for(int i = 0; i < idsStrs.length; i++){
            blogService.delete(Integer.parseInt(idsStrs[i]));
        }
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("success",true);
        try {
            ResponseUtil.write(response,jsonObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
