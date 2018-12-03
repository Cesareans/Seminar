package seminar.entity.hso;

/**
 * @author Cesare
 */
public class ClbumSeminarHso {
    private String clbumId;
    private String seminarId;

    public ClbumSeminarHso(String clbumId, String seminarId) {
        this.clbumId = clbumId;
        this.seminarId = seminarId;
    }

    public String getClbumId() {
        return clbumId;
    }

    public void setClbumId(String clbumId) {
        this.clbumId = clbumId;
    }

    public String getSeminarId() {
        return seminarId;
    }

    public void setSeminarId(String seminarId) {
        this.seminarId = seminarId;
    }
}
