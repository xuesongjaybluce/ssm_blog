package ssm.blog.service;

import ssm.blog.entity.Link;

import java.util.List;

/**
 * Created by Administrator on 2017/1/9 0009.
 */
public interface LinkService {

    //获取全部链接
    public List<Link> getLinkData();
}
