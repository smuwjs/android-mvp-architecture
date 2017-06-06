package me.jeeson.android.mvp.demo.mvp.model.entity;

/**
 * Created by Jeeson on 2017/5/15.
 * TextContent
 */

public class TextContent {
    private String title;
    private String content;


    public TextContent(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
