package ssm.blog.serviceImpl;

import org.springframework.stereotype.Service;
import ssm.blog.dao.BloggerDao;
import ssm.blog.entity.Blogger;
import ssm.blog.service.BloggerService;

import javax.annotation.Resource;


/**
 * 博主接口实现   service 实现类
 * Created by Administrator on 2016/12/23 0023.
 */
@Service("BloggerService")
public class BloggerServiceImpl implements BloggerService{
    @Resource
    private BloggerDao bloggerDao;

    public Blogger getByUsername(String username) {
        return bloggerDao.getByUsername(username);
    }

    public Blogger getBloggerData(){ return bloggerDao.getBloggerData();}
}
