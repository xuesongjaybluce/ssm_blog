package ssm.blog.entity;

/**
 * Created by Administrator on 2017/1/9 0009.
 */
public class Link {
    /**
     * 链接ID
     */
    private Integer id;
    /**
     * 链接名
     */
    private String linkName;
    /**
     * 链接地址
     */
    private String linkUrl;
    /**
     * 链接排序
     */
    private Integer linkOrder;

    public Link() {
    }

    public String getLinkName() {
        return linkName;
    }

    public void setLinkName(String linkName) {
        this.linkName = linkName;
    }

    public String getLinkUrl() {
        return linkUrl;
    }

    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl;
    }

    public Integer getLinkOrder() {
        return linkOrder;
    }

    public void setLinkOrder(Integer linkOrder) {
        this.linkOrder = linkOrder;
    }

    @Override
    public String toString() {
        return "Link{" +
                "linkName='" + linkName + '\'' +
                ", linkUrl='" + linkUrl + '\'' +
                ", linkOrder=" + linkOrder +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
