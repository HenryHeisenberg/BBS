package data;

import java.util.Date;
import javax.persistence.*;

@Table(name = "user_information")
public class UserInformation {
    @Id
    @Column(name = "user_id")
    private String userId;

    private String username;

    /**
     * 头像，保存头像图片路径
     */
    private String head;

    @Column(name = "register_date")
    private Date registerDate;

    /**
     * @return user_id
     */
    public String getUserId() {
        return userId;
    }

    /**
     * @param userId
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取头像，保存头像图片路径
     *
     * @return head - 头像，保存头像图片路径
     */
    public String getHead() {
        return head;
    }

    /**
     * 设置头像，保存头像图片路径
     *
     * @param head 头像，保存头像图片路径
     */
    public void setHead(String head) {
        this.head = head;
    }

    /**
     * @return register_date
     */
    public Date getRegisterDate() {
        return registerDate;
    }

    /**
     * @param registerDate
     */
    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }
}