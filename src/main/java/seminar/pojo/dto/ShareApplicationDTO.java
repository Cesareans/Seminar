package seminar.pojo.dto;

import seminar.logger.DebugLogger;

/**
 * @author Cesare
 */
public class ShareApplicationDTO {
    private String mainCourseId;
    private String subCourseId;
    private Integer shareType;

    @Override
    public String toString() {
        return DebugLogger.toJsonString(this);
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

    public Integer getShareType() {
        return shareType;
    }

    public void setShareType(Integer shareType) {
        this.shareType = shareType;
    }
}
