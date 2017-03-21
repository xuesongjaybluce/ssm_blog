package ssm.blog.entity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 2017/1/30 0030.
 */
public class Blog {
    /**
     * 博客id
     */
    private Integer id;
    /**
     * 博客标题
     */
    private String title;
    /**
     * 博客摘要
     */
    private String summary;
    /**
     * 发布日期
     */
    private Date releaseDate;
    //格式化日期
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    /**
     * 点击次数
     */
    private Integer clickHit;
    /**
     * 评论次数
     */
    private Integer replyHit;
    /**
     * 带标签内容
     */
    private String content;
    /**
     * 不带标签内容,用于Lucene索引中
     */
    private String contentNoTag;
    /**
     * 关键字
     */
    private String keyWord;

    /**
     * 博客类型
     */
    private BlogType blogType;
    /**
     * 博客数量，用于单天归档查询
     */
    private Integer blogCount;
    /**
     * 发布日期字符串
     */
    private String releaseDateStr;

    /**
     * 博客里存在的图片
     */
    private List<String> imageList = new LinkedList<String>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Date getReleaseDate() {
        simpleDateFormat.format(releaseDate);
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Integer getClickHit() {
        return clickHit;
    }

    public void setClickHit(Integer clickHit) {
        this.clickHit = clickHit;
    }

    public Integer getReplyHit() {
        return replyHit;
    }

    public void setReplyHit(Integer replyHit) {
        this.replyHit = replyHit;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContentNoTag() {
        return contentNoTag;
    }

    public void setContentNoTag(String contentNoTag) {
        this.contentNoTag = contentNoTag;
    }

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }

    public BlogType getBlogType() {
        return blogType;
    }

    public void setBlogType(BlogType blogType) {
        this.blogType = blogType;
    }

    public Integer getBlogCount() {
        return blogCount;
    }

    public void setBlogCount(Integer blogCount) {
        this.blogCount = blogCount;
    }

    public String getReleaseDateStr() {
        this.releaseDateStr = simpleDateFormat.format(releaseDate);
        return releaseDateStr;
    }

    public void setReleaseDateStr(String releaseDateStr) {
        this.releaseDateStr = releaseDateStr;
    }

    public List<String> getImageList() {
        return imageList;
    }

    public void setImageList(List<String> imageList) {
        this.imageList = imageList;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", summary='" + summary + '\'' +
                ", releaseDate=" + releaseDate +
                ", clickHit=" + clickHit +
                ", replyHit=" + replyHit +
                ", content='" + content + '\'' +
                ", contentNoTag='" + contentNoTag + '\'' +
                ", keyWord='" + keyWord + '\'' +
                ", blogType=" + blogType +
                ", blogCount=" + blogCount +
                ", releaseDateStr='" + releaseDateStr + '\'' +
                ", imageList=" + imageList +
                '}';
    }
}
