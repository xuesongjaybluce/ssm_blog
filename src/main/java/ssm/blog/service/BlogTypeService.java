package ssm.blog.service;

import ssm.blog.entity.BlogType;

import java.util.List;

/**
 * Created by Administrator on 2017/2/14 0014.
 */
public interface BlogTypeService {
    //R by id
    public BlogType findById(Integer id);
    //R
    public List<BlogType> listBlogType();
    //C
    public Integer addBlogType(BlogType blogType);
    //U
    public Integer editBlogType(BlogType blogType);
    //D
    public Integer deleteBlogType(Integer id);
}
