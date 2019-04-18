package data;

import javax.persistence.*;

@Table(name = "user")
public class User {
    @Id
    @Column(name = "user_id")
    private String userId;

    private String email;

    /**
     * ʹ��md5���ܣ��̶�����32���ַ�
     */
    private String password;

    /**
     * ������ֵ���̶�����24λ�ַ�
     */
    private String salt;

    /**
     * 0-����Ա   1-��ͨ�û�   2-�������û�
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
     * ��ȡʹ��md5���ܣ��̶�����32���ַ�
     *
     * @return password - ʹ��md5���ܣ��̶�����32���ַ�
     */
    public String getPassword() {
        return password;
    }

    /**
     * ����ʹ��md5���ܣ��̶�����32���ַ�
     *
     * @param password ʹ��md5���ܣ��̶�����32���ַ�
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * ��ȡ������ֵ���̶�����24λ�ַ�
     *
     * @return salt - ������ֵ���̶�����24λ�ַ�
     */
    public String getSalt() {
        return salt;
    }

    /**
     * ����������ֵ���̶�����24λ�ַ�
     *
     * @param salt ������ֵ���̶�����24λ�ַ�
     */
    public void setSalt(String salt) {
        this.salt = salt;
    }

    /**
     * ��ȡ0-����Ա   1-��ͨ�û�   2-�������û�
     *
     * @return role - 0-����Ա   1-��ͨ�û�   2-�������û�
     */
    public Byte getRole() {
        return role;
    }

    /**
     * ����0-����Ա   1-��ͨ�û�   2-�������û�
     *
     * @param role 0-����Ա   1-��ͨ�û�   2-�������û�
     */
    public void setRole(Byte role) {
        this.role = role;
    }
}