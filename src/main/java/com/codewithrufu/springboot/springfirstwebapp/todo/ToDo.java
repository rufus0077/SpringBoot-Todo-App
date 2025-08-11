package com.codewithrufu.springboot.springfirstwebapp.todo;

import java.time.LocalDate;
//to store we need DB




public class ToDo {
    private int id;
    private String description;
    private String userName;
    private boolean isDone;
    private LocalDate targetDate;

    public ToDo(int id , String userName, String description, LocalDate targetDate, boolean isDone) {
        this.id = id;
        this.description = description;
        this.userName = userName;
        this.targetDate = targetDate;
        this.isDone = isDone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    public LocalDate getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(LocalDate targetDate) {
        this.targetDate = targetDate;
    }

    @Override
    public String toString() {
        return "ToDo{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", userName='" + userName + '\'' +
                ", isDone=" + isDone +
                ", targetDate=" + targetDate +
                '}';
    }
}
