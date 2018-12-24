package seminar.pojo.websocket;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author Cesare
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class RawMessage {
    private String type;
    private String content;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
