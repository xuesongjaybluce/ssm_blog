package ssm.blog.dao;

import ssm.blog.entity.Comment;

import java.util.List;

/**
 * Created by Administrator on 2017/3/10 0010.
 */
public interface CommentDao {
    //c
    public Integer addComment(Comment comment);
    //r
    public List<Comment> listByBlogId(Integer blog_id);
    //未审核的列表
    public List<Comment> commentListForAudit();
    //r by id
    public Comment commentById(Integer id);
    //通过评论
    public Integer editComment(Comment comment);
}
