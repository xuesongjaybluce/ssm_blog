package ssm.blog.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2017/3/10 0010.
 */
public class Comment {

    private Integer id;
    private String content;
    private Date commentDate;
    private String commentDateStr;
    //格式化日期
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private String userIp;
    private Integer state;
    private Blog blog;
    private Integer blog_id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(Date commentDate) {
        this.commentDate = commentDate;
    }

    public String getCommentDateStr() {
        commentDateStr = simpleDateFormat.format(commentDate);
        return commentDateStr;
    }

    public void setCommentDateStr(String commentDateStr) {
        this.commentDateStr = commentDateStr;
    }

    public String getUserIp() {
        return userIp;
    }

    public void setUserIp(String userIp) {
        this.userIp = userIp;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getBlog_id() {
        return blog_id;
    }

    public void setBlog_id(Integer blog_id) {
        this.blog_id = blog_id;
    }

    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", commentDate=" + commentDate +
                ", commentDateStr='" + commentDateStr + '\'' +
                ", simpleDateFormat=" + simpleDateFormat +
                ", userIp='" + userIp + '\'' +
                ", state=" + state +
                ", blog=" + blog +
                ", blog_id=" + blog_id +
                '}';
    }
}
