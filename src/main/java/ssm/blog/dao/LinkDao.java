package ssm.blog.dao;

import ssm.blog.entity.Link;

import java.util.List;

/**
 * Created by Administrator on 2017/1/9 0009.
 */
public interface LinkDao {

    //获取链接信息
    public List<Link> getLinkData();
}
