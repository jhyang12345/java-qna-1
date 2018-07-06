package codesquad.domain;

import java.util.Date;

public class Question {
    private String writer;
    private String title;
    private String contents;
    private Date date;

    public Question(){
        date = new Date();
    }

    public Date getDate() {
        return date;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }
}
