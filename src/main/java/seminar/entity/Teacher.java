package seminar.entity;

/**
 * @author Cesare
 */
public class Teacher {
    private String id;
    private String badgeNum;
    private String password;
    private String name;
    private String email;
    private boolean activated;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBadgeNum() {
        return badgeNum;
    }

    public void setBadgeNum(String badgeNum) {
        this.badgeNum = badgeNum;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isActivated() {
        return activated;
    }

    public void setActivated(boolean activated) {
        this.activated = activated;
    }
}
