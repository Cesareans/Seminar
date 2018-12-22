package seminar.pojo.websocket;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author Cesare
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class RawMessage {
    private String type;
    private String jsonContent;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getJsonContent() {
        return jsonContent;
    }

    public void setJsonContent(String jsonContent) {
        this.jsonContent = jsonContent;
    }

}
