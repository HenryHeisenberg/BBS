package data;

import javax.persistence.*;

@Table(name = "theme")
public class Theme {
    @Id
    @Column(name = "theme_id")
    private Byte themeId;

    @Column(name = "theme_name")
    private String themeName;

    /**
     * @return theme_id
     */
    public Byte getThemeId() {
        return themeId;
    }

    /**
     * @param themeId
     */
    public void setThemeId(Byte themeId) {
        this.themeId = themeId;
    }

    /**
     * @return theme_name
     */
    public String getThemeName() {
        return themeName;
    }

    /**
     * @param themeName
     */
    public void setThemeName(String themeName) {
        this.themeName = themeName;
    }
}