package data;

import java.util.Date;
import javax.persistence.*;

@Table(name = "post_content")
public class PostContent {
    @Id
    @Column(name = "post_id")
    private Long postId;

    @Id
    @Column(name = "floor_id")
    private Integer floorId;

    @Column(name = "create_datetime")
    private Date createDatetime;

    @Column(name = "authod_id")
    private String authodId;

    @Column(name = "authod_username")
    private String authodUsername;

    /**
     * 帖子内容
     */
    private String content;

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
     * @return floor_id
     */
    public Integer getFloorId() {
        return floorId;
    }

    /**
     * @param floorId
     */
    public void setFloorId(Integer floorId) {
        this.floorId = floorId;
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
     * @return authod_id
     */
    public String getAuthodId() {
        return authodId;
    }

    /**
     * @param authodId
     */
    public void setAuthodId(String authodId) {
        this.authodId = authodId;
    }

    /**
     * @return authod_username
     */
    public String getAuthodUsername() {
        return authodUsername;
    }

    /**
     * @param authodUsername
     */
    public void setAuthodUsername(String authodUsername) {
        this.authodUsername = authodUsername;
    }

    /**
     * 获取帖子内容
     *
     * @return content - 帖子内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置帖子内容
     *
     * @param content 帖子内容
     */
    public void setContent(String content) {
        this.content = content;
    }
}