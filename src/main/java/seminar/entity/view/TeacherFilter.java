package seminar.entity.view;

/**
 * @author Cesare
 */
public class TeacherFilter {
    private boolean newFilter = false;
    private int page = 0;
    private int count = 0;
    private String name = null;
    private String badgeNum = null;

    public boolean isNewFilter() {
        return newFilter;
    }

    public void setNewFilter(boolean newFilter) {
        this.newFilter = newFilter;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBadgeNum() {
        return badgeNum;
    }

    public void setBadgeNum(String badgeNum) {
        this.badgeNum = badgeNum;
    }
}
