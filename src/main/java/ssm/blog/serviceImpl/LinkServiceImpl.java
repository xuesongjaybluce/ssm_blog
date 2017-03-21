package ssm.blog.serviceImpl;

import org.springframework.stereotype.Service;
import ssm.blog.dao.LinkDao;
import ssm.blog.entity.Link;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2017/1/9 0009.
 */
@Service("LinkService")
public class LinkServiceImpl implements ssm.blog.service.LinkService {
    @Resource
    private LinkDao linkDao;

    public List<Link> getLinkData() {
        return linkDao.getLinkData();
    }
}
