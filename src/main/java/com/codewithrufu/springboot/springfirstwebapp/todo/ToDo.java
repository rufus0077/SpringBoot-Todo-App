package com.codewithrufu.springboot.springfirstwebapp.todo;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;


@Entity
@Table(name = "todo")
public class ToDo {

    public ToDo() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Size(min = 10, message = "Enter at least 10 characters")
    private String description;
    
    @Column(name = "user_name")
    private String userName;
    private boolean done;
    private LocalDate targetDate;

    public ToDo(int id, String userName, String description, LocalDate targetDate, boolean done) {
        this.id = id;
        this.description = description;
        this.userName = userName;
        this.targetDate = targetDate;
        this.done = done; // FIXED: previously used incorrect variable
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

    // FIXED: Proper getter naming for boolean
    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done; // FIXED: previously was "done = done" (no effect)
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
                ", done=" + done +
                ", targetDate=" + targetDate +
                '}';
    }
}
