package data;

import java.util.Date;
import javax.persistence.*;

@Table(name = "message")
public class Message {
    @Id
    @Column(name = "messgae_id")
    private Long messgaeId;

    @Column(name = "send_id")
    private String sendId;

    @Column(name = "send_username")
    private String sendUsername;

    @Column(name = "receive_id")
    private String receiveId;

    @Column(name = "receive_username")
    private String receiveUsername;

    @Column(name = "create_time")
    private Date createTime;

    /**
     * @return messgae_id
     */
    public Long getMessgaeId() {
        return messgaeId;
    }

    /**
     * @param messgaeId
     */
    public void setMessgaeId(Long messgaeId) {
        this.messgaeId = messgaeId;
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
     * @return receive_id
     */
    public String getReceiveId() {
        return receiveId;
    }

    /**
     * @param receiveId
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
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}