package data;

import javax.persistence.*;

@Table(name = "user")
public class User {
    @Id
    @Column(name = "user_id")
    private String userId;

    private String email;

    /**
     * 使用md5加密，固定长度32个字符
     */
    private String password;

    /**
     * 密码盐值，固定长度24位字符
     */
    private String salt;

    /**
     * 0-管理员   1-普通用户   2-黑名单用户
     */
    private Byte role;

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
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取使用md5加密，固定长度32个字符
     *
     * @return password - 使用md5加密，固定长度32个字符
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置使用md5加密，固定长度32个字符
     *
     * @param password 使用md5加密，固定长度32个字符
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取密码盐值，固定长度24位字符
     *
     * @return salt - 密码盐值，固定长度24位字符
     */
    public String getSalt() {
        return salt;
    }

    /**
     * 设置密码盐值，固定长度24位字符
     *
     * @param salt 密码盐值，固定长度24位字符
     */
    public void setSalt(String salt) {
        this.salt = salt;
    }

    /**
     * 获取0-管理员   1-普通用户   2-黑名单用户
     *
     * @return role - 0-管理员   1-普通用户   2-黑名单用户
     */
    public Byte getRole() {
        return role;
    }

    /**
     * 设置0-管理员   1-普通用户   2-黑名单用户
     *
     * @param role 0-管理员   1-普通用户   2-黑名单用户
     */
    public void setRole(Byte role) {
        this.role = role;
    }
}