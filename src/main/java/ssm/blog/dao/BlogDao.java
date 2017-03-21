package ssm.blog.dao;

import ssm.blog.entity.Blog;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/1/31 0031.
 */
public interface BlogDao {
    //添加博客
    public Integer addBlog(Blog blog);
    //R
    public List<Blog> listBlog(Map limit);
    //通过博客类型查找博客
    public List<Blog> listByBlogTypeId(Integer blogTypeId);
    //通过id查找博客
    public Blog findById(Integer id);
    //修改博客
    public Integer editBlog(Blog blog);
    //D
    public Integer delete(Integer id);
    //博客数量
    public Integer countBlog();
}
