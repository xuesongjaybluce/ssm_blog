package ssm.blog.dao;

import ssm.blog.entity.BlogType;

import java.util.List;

/**
 * Created by Administrator on 2017/1/31 0031.
 */
public interface BlogTypeDao {
    //通过ID查找博客类型
    public BlogType findById(Integer id);
    //博客类型列表
    public List<BlogType> listBlogType();
    //C
    public Integer addBlogType(BlogType blogType);
    //U
    public Integer editBlogType(BlogType blogType);
    //D
    public Integer deleteBlogType(Integer id);
}
