package ssm.blog.service;

import ssm.blog.entity.Blog;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/2/1 0001.
 */
public interface BlogService {

    //添加博客
    public Integer addBlog(Blog blog);
    //通过博客类型查找博客
    public List<Blog> listByBlogTypeId(Integer blogTypeId);
    //R
    public List<Blog> listBlog(Map limit);
    //通过博客id查找博客
    public Blog findById(Integer id);
    //u
    public Integer editBlog(Blog blog);
    //D
    public Integer delete(Integer id);
    //博客数量
    public Integer countBlog();

}
