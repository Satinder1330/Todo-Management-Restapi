package com.learning.todo.Todo_Manager.models;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDate;
import java.sql.Date;


public class Todo {
    private Integer id;
    private String title;
    private String content;
    private String status;
    private Date addedDate;
    @JsonFormat(pattern = "yyyy-MM-dd") //change it to any format to accept the date from the user
    private Date completeBefore;

    public Todo(Integer id, String title, String content,
                String status, Date addedDate, Date completeBefore) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.status = status;
        this.addedDate = addedDate;
        this.completeBefore = completeBefore;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Todo() { }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getAddedDate() {
        return Date.valueOf(LocalDate.now());
    }

    public void setAddedDate(Date addedDate) {

        this.addedDate = Date.valueOf(LocalDate.now());
    }

    public Date getCompleteBefore() {
        return completeBefore;
    }

    public void setCompleteBefore(Date completeBefore) {
        this.completeBefore = completeBefore;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Todo{");
        sb.append("id=").append(id);
        sb.append(", title='").append(title).append('\'');
        sb.append(", content='").append(content).append('\'');
        sb.append(", status='").append(status).append('\'');
        sb.append(", addedDate=").append(addedDate);
        sb.append(", completeBefore=").append(completeBefore);
        sb.append("}\n");
        return sb.toString();
    }

}
