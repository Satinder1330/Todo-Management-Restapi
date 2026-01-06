package com.learning.todo.Todo_Manager.models;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.util.Date;

public class Todo {
    private Integer id;
    private String title;
    private String content;
    private String status;
    private LocalDate addedDate;
    @JsonFormat(pattern = "yyyy-MM-dd") //change it to any format to accept the date from the user
    private LocalDate completeBefore;

    public Todo(Integer id, String title, String content,
                String status, LocalDate addedDate, LocalDate completeBefore) {
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

    public LocalDate getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(LocalDate addedDate) {
        this.addedDate = addedDate;
    }

    public LocalDate getCompleteBefore() {
        return completeBefore;
    }

    public void setCompleteBefore(LocalDate completeBefore) {
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
        sb.append('}');
        return sb.toString();
    }
}
