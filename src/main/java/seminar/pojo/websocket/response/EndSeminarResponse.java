package seminar.pojo.websocket.response;

import seminar.pojo.websocket.monitor.SeminarMonitor;

public class EndSeminarResponse implements Response {
    private String placeHolder;
    @Override
    public Response execute(SeminarMonitor monitor) {
        placeHolder = "";
        return this;
    }

    public String getPlaceHolder() {
        return placeHolder;
    }

    public void setPlaceHolder(String placeHolder) {
        this.placeHolder = placeHolder;
    }
}
