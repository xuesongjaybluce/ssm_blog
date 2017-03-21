package ssm.blog.serviceImpl;

import org.springframework.stereotype.Service;
import ssm.blog.dao.BlogTypeDao;
import ssm.blog.entity.BlogType;
import ssm.blog.service.BlogTypeService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2017/2/14 0014.
 */
@Service("BlogTypeService")
public class BlogTypeServiceImpl implements BlogTypeService{
    @Resource
    BlogTypeDao blogTypeDao;

    public BlogType findById(Integer id) { return blogTypeDao.findById(id); }

    public List<BlogType> listBlogType() {
        return blogTypeDao.listBlogType();
    }

    public Integer addBlogType(BlogType blogType) {
        return blogTypeDao.addBlogType(blogType);
    }

    public Integer editBlogType(BlogType blogType) {
        return blogTypeDao.editBlogType(blogType);
    }

    public Integer deleteBlogType(Integer id){
        return blogTypeDao.deleteBlogType(id);
    }


}
