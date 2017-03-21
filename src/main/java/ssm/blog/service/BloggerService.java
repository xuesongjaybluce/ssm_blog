package ssm.blog.service;

import ssm.blog.entity.Blogger;

/**
 * 博主接口service
 * Created by Administrator on 2016/12/23 0023.
 */
public interface BloggerService {

    public Blogger getByUsername(String username);

    public Blogger getBloggerData();
}
