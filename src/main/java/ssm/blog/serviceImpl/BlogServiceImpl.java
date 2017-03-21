package ssm.blog.serviceImpl;

import org.springframework.stereotype.Service;
import ssm.blog.dao.BlogDao;
import ssm.blog.entity.Blog;
import ssm.blog.service.BlogService;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/2/1 0001.
 */
@Service("BlogService")
public class BlogServiceImpl implements BlogService {
    @Resource
    private BlogDao blogDao;
    //添加博客
    public Integer addBlog(Blog blog) { return blogDao.addBlog(blog); }

    public List<Blog> listByBlogTypeId(Integer blogTypeId) {
        return blogDao.listByBlogTypeId(blogTypeId);
    }

    public List<Blog> listBlog(Map limit) {
        return blogDao.listBlog(limit);
    }

    public Blog findById(Integer id) {
        return blogDao.findById(id);
    }

    public Integer editBlog(Blog blog) {
        return blogDao.editBlog(blog);
    }

    public Integer delete(Integer id) {
        return blogDao.delete(id);
    }

    public Integer countBlog() {
        return blogDao.countBlog();
    }
}
