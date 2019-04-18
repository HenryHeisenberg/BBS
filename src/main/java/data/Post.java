package data;

import java.util.Date;
import javax.persistence.*;

@Table(name = "post")
public class Post {
    @Id
    @Column(name = "post_id")
    private Long postId;

    private String title;

    @Column(name = "author_id")
    private String authorId;

    @Column(name = "create_datetime")
    private Date createDatetime;

    /**
     * 封面图片路径
     */
    private String cover;

    /**
     * 主题id，可根据id从表theme获取
     */
    private Byte theme;

    /**
     * 帖子访问量
     */
    private Integer traffic;

    /**
     * 是否为精华置顶帖子，0-否  1-是
     */
    private Boolean top;

    /**
     * @return post_id
     */
    public Long getPostId() {
        return postId;
    }

    /**
     * @param postId
     */
    public void setPostId(Long postId) {
        this.postId = postId;
    }

    /**
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return author_id
     */
    public String getAuthorId() {
        return authorId;
    }

    /**
     * @param authorId
     */
    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    /**
     * @return create_datetime
     */
    public Date getCreateDatetime() {
        return createDatetime;
    }

    /**
     * @param createDatetime
     */
    public void setCreateDatetime(Date createDatetime) {
        this.createDatetime = createDatetime;
    }

    /**
     * 获取封面图片路径
     *
     * @return cover - 封面图片路径
     */
    public String getCover() {
        return cover;
    }

    /**
     * 设置封面图片路径
     *
     * @param cover 封面图片路径
     */
    public void setCover(String cover) {
        this.cover = cover;
    }

    /**
     * 获取主题id，可根据id从表theme获取
     *
     * @return theme - 主题id，可根据id从表theme获取
     */
    public Byte getTheme() {
        return theme;
    }

    /**
     * 设置主题id，可根据id从表theme获取
     *
     * @param theme 主题id，可根据id从表theme获取
     */
    public void setTheme(Byte theme) {
        this.theme = theme;
    }

    /**
     * 获取帖子访问量
     *
     * @return traffic - 帖子访问量
     */
    public Integer getTraffic() {
        return traffic;
    }

    /**
     * 设置帖子访问量
     *
     * @param traffic 帖子访问量
     */
    public void setTraffic(Integer traffic) {
        this.traffic = traffic;
    }

    /**
     * 获取是否为精华置顶帖子，0-否  1-是
     *
     * @return top - 是否为精华置顶帖子，0-否  1-是
     */
    public Boolean getTop() {
        return top;
    }

    /**
     * 设置是否为精华置顶帖子，0-否  1-是
     *
     * @param top 是否为精华置顶帖子，0-否  1-是
     */
    public void setTop(Boolean top) {
        this.top = top;
    }
}