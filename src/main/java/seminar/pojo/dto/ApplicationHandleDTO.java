package seminar.pojo.dto;

import seminar.logger.DebugLogger;

/**
 * @author Cesare
 */
public class ApplicationHandleDTO {
    private String appId;
    private String mainCourseId;
    private String subCourseId;
    private String teamId;
    /**
     * 0 - ShareSeminarApplication
     * 1 - ShareTeamApplication
     * 2 - TeamValidApplication
     */
    private Integer appType;
    /**
     * 0 - 拒绝
     * 1 - 接收
     */
    private Integer operationType;

    @Override
    public String toString() {
        return DebugLogger.toJsonString(this);
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getMainCourseId() {
        return mainCourseId;
    }

    public void setMainCourseId(String mainCourseId) {
        this.mainCourseId = mainCourseId;
    }

    public String getSubCourseId() {
        return subCourseId;
    }

    public void setSubCourseId(String subCourseId) {
        this.subCourseId = subCourseId;
    }

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    public Integer getAppType() {
        return appType;
    }

    public void setAppType(Integer appType) {
        this.appType = appType;
    }

    public Integer getOperationType() {
        return operationType;
    }

    public void setOperationType(Integer operationType) {
        this.operationType = operationType;
    }
}
