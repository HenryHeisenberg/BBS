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
     * ����ظ����������۵�id
     */
    @Column(name = "send_id")
    private String sendId;

    @Column(name = "send_username")
    private String sendUsername;

    /**
     * ���ظ����������˵�id
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
     * ��ȡ����ظ����������۵�id
     *
     * @return send_id - ����ظ����������۵�id
     */
    public String getSendId() {
        return sendId;
    }

    /**
     * ���÷���ظ����������۵�id
     *
     * @param sendId ����ظ����������۵�id
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
     * ��ȡ���ظ����������˵�id
     *
     * @return receive_id - ���ظ����������˵�id
     */
    public String getReceiveId() {
        return receiveId;
    }

    /**
     * ���ñ��ظ����������˵�id
     *
     * @param receiveId ���ظ����������˵�id
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