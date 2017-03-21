package ssm.blog.entity;

/**
 * Created by Administrator on 2017/1/31 0031.
 */
public class BlogType {

    private Integer id;

    private String typeName;//类型名

    private Integer orderNum;

    private Integer blogCount;//统计不同类型的博客数量

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    public Integer getBlogCount() {
        return blogCount;
    }

    public void setBlogCount(Integer blogCount) {
        this.blogCount = blogCount;
    }
}
