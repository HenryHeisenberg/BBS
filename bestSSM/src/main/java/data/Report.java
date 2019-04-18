package data;

import java.util.Date;
import javax.persistence.*;

@Table(name = "report")
public class Report {
    @Id
    @Column(name = "report_id")
    private Long reportId;

    @Column(name = "send_id")
    private String sendId;

    @Column(name = "send_username")
    private String sendUsername;

    @Column(name = "create_datetime")
    private Date createDatetime;

    @Column(name = "post_id")
    private Long postId;

    @Column(name = "floor_id")
    private Integer floorId;

    @Column(name = "comment_id")
    private Integer commentId;

    /**
     * @return report_id
     */
    public Long getReportId() {
        return reportId;
    }

    /**
     * @param reportId
     */
    public void setReportId(Long reportId) {
        this.reportId = reportId;
    }

    /**
     * @return send_id
     */
    public String getSendId() {
        return sendId;
    }

    /**
     * @param sendId
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
}