package data;

import java.util.Date;
import javax.persistence.*;

@Table(name = "post_comment")
public class PostComment {
    @Id
    @Column(name = "post_id")
    private Long postId;

    @Id
    @Column(name = "floor_id")
    private Integer floorId;

    @Id
    @Column(name = "comment_id")
    private Integer commentId;

    /**
     * 发表回复，发表评论的id
     */
    @Column(name = "send_id")
    private String sendId;

    @Column(name = "send_username")
    private String sendUsername;

    /**
     * 被回复，被评论人的id
     */
    @Column(name = "receive_id")
    private String receiveId;

    @Column(name = "receive_username")
    private String receiveUsername;

    @Column(name = "create_dateime")
    private Date createDateime;

    private String comment;

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
     * @return comment_id
     */
    public Integer getCommentId() {
        return commentId;
    }

    /**
     * @param commentId
     */
    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    /**
     * 获取发表回复，发表评论的id
     *
     * @return send_id - 发表回复，发表评论的id
     */
    public String getSendId() {
        return sendId;
    }

    /**
     * 设置发表回复，发表评论的id
     *
     * @param sendId 发表回复，发表评论的id
     */
    public void setSendId(String sendId) {
        this.sendId = sendId;
    }

    /**
     * @return send_username
     */
    public String getSendUsername() {
        return sendUsername;
    }

    /**
     * @param sendUsername
     */
    public void setSendUsername(String sendUsername) {
        this.sendUsername = sendUsername;
    }

    /**
     * 获取被回复，被评论人的id
     *
     * @return receive_id - 被回复，被评论人的id
     */
    public String getReceiveId() {
        return receiveId;
    }

    /**
     * 设置被回复，被评论人的id
     *
     * @param receiveId 被回复，被评论人的id
     */
    public void setReceiveId(String receiveId) {
        this.receiveId = receiveId;
    }

    /**
     * @return receive_username
     */
    public String getReceiveUsername() {
        return receiveUsername;
    }

    /**
     * @param receiveUsername
     */
    public void setReceiveUsername(String receiveUsername) {
        this.receiveUsername = receiveUsername;
    }

    /**
     * @return create_dateime
     */
    public Date getCreateDateime() {
        return createDateime;
    }

    /**
     * @param createDateime
     */
    public void setCreateDateime(Date createDateime) {
        this.createDateime = createDateime;
    }

    /**
     * @return comment
     */
    public String getComment() {
        return comment;
    }

    /**
     * @param comment
     */
    public void setComment(String comment) {
        this.comment = comment;
    }
}