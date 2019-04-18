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
     * ����ͼƬ·��
     */
    private String cover;

    /**
     * ����id���ɸ���id�ӱ�theme��ȡ
     */
    private Byte theme;

    /**
     * ���ӷ�����
     */
    private Integer traffic;

    /**
     * �Ƿ�Ϊ�����ö����ӣ�0-��  1-��
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
     * ��ȡ����ͼƬ·��
     *
     * @return cover - ����ͼƬ·��
     */
    public String getCover() {
        return cover;
    }

    /**
     * ���÷���ͼƬ·��
     *
     * @param cover ����ͼƬ·��
     */
    public void setCover(String cover) {
        this.cover = cover;
    }

    /**
     * ��ȡ����id���ɸ���id�ӱ�theme��ȡ
     *
     * @return theme - ����id���ɸ���id�ӱ�theme��ȡ
     */
    public Byte getTheme() {
        return theme;
    }

    /**
     * ��������id���ɸ���id�ӱ�theme��ȡ
     *
     * @param theme ����id���ɸ���id�ӱ�theme��ȡ
     */
    public void setTheme(Byte theme) {
        this.theme = theme;
    }

    /**
     * ��ȡ���ӷ�����
     *
     * @return traffic - ���ӷ�����
     */
    public Integer getTraffic() {
        return traffic;
    }

    /**
     * �������ӷ�����
     *
     * @param traffic ���ӷ�����
     */
    public void setTraffic(Integer traffic) {
        this.traffic = traffic;
    }

    /**
     * ��ȡ�Ƿ�Ϊ�����ö����ӣ�0-��  1-��
     *
     * @return top - �Ƿ�Ϊ�����ö����ӣ�0-��  1-��
     */
    public Boolean getTop() {
        return top;
    }

    /**
     * �����Ƿ�Ϊ�����ö����ӣ�0-��  1-��
     *
     * @param top �Ƿ�Ϊ�����ö����ӣ�0-��  1-��
     */
    public void setTop(Boolean top) {
        this.top = top;
    }
}