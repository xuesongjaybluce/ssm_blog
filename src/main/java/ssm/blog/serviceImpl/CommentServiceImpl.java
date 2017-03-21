package ssm.blog.serviceImpl;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import ssm.blog.dao.BlogDao;
import ssm.blog.dao.CommentDao;
import ssm.blog.entity.Comment;
import ssm.blog.service.CommentService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2017/3/10 0010.
 */
@Service
public class CommentServiceImpl implements CommentService{

    @Resource
    private CommentDao commentDao;

    public Integer addComment(Comment comment) {
        return commentDao.addComment(comment);
    }

    public List<Comment> commentListByBlog(Integer blog_id) {
        return commentDao.listByBlogId(blog_id);
    }

    public List<Comment> commentListForAudit() {
        return commentDao.commentListForAudit();
    }

    public Comment commentById(Integer id) {
        return commentDao.commentById(id);
    }

    public Integer editComment(Comment comment) {
        return commentDao.editComment(comment);
    }
}
