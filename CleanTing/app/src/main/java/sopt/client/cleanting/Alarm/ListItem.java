package sopt.client.cleanting.Alarm;

/**
 * Created by 진영 on 2017-07-01.
 */

public class ListItem {
    private String content;
    private String time;

    public ListItem(String content, String time) {
        this.content = content;
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
