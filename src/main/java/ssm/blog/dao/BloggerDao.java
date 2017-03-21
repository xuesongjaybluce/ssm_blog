package ssm.blog.dao;

import ssm.blog.entity.Blogger;

/**
 * 博主接口DAO
 * Created by Administrator on 2016/12/23 0023.
 */
public interface BloggerDao {

    //通过用户名查找用户
    public Blogger getByUsername(String username);

    //获取博主信息
    public Blogger getBloggerData();
}
