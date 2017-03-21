package ssm.blog.controllerAdmin;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ssm.blog.entity.BlogType;
import ssm.blog.service.BlogService;
import ssm.blog.service.BlogTypeService;
import ssm.blog.util.ResponseUtil;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by Administrator on 2017/2/15 0015.
 */
@Controller
@RequestMapping("/admin/blogType")
public class BlogTypeController {
    @Resource
    BlogTypeService blogTypeService;
    @Resource
    BlogService blogService;
    @RequestMapping("/listBlogType")
    public String listBlogType(HttpServletResponse response){

        List<BlogType> blogTypeList = blogTypeService.listBlogType();

        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = JSONArray.fromObject(blogTypeList);

        jsonObject.put("rows",jsonArray);
        try {
            ResponseUtil.write(response,jsonObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    @RequestMapping("/delete")
    public String delete(@RequestParam(value="ids",required = false)String ids, HttpServletResponse response){

        String[] idsStr = ids.split(",");
        JSONObject jsonObject = new JSONObject();
        for(int i=0; i<idsStr.length; i++){
            int id = Integer.parseInt(idsStr[i]);
            if(blogService.listByBlogTypeId(id).size() > 0){
                jsonObject.put("exist","id为" + id + "的博客类型下有博客存在，无法删除");
            }else {
                blogTypeService.deleteBlogType(id);
            }
        }
        jsonObject.put("success",true);
        try {
            ResponseUtil.write(response,jsonObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping("/save")
    public String save(BlogType blogType,HttpServletResponse response){

        int resultTotal;

        if(blogType.getId() == null) {
            resultTotal = blogTypeService.addBlogType(blogType);
        }else{
            resultTotal = blogTypeService.editBlogType(blogType);
        }

        JSONObject jsonObject = new JSONObject();

        if(resultTotal > 0){
            jsonObject.put("success",true);
        }else{
            jsonObject.put("success",false);
        }
        try {
            ResponseUtil.write(response,jsonObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  null;
    }

}
