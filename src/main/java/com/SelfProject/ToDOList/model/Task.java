package com.SelfProject.ToDOList.model;

import jakarta.persistence.*;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "task_id_seq")
    @SequenceGenerator(
            name = "task_id_seq",
            sequenceName = "task_id_seq",   // ← you can name it anything
            allocationSize = 1              // 1 = safe, 50 = faster but can cause gaps
    )
    private Long id;
    private String title;
    private boolean completed=false;
    private LocalDateTime createdAt=LocalDateTime.now();
    private LocalDateTime completedAt;
    private LocalDate dueDate;
    private Duration duration;
    /*---------------- Constructors ----------------*/
    public Task() {

    }

    public Task(String title,LocalDate dueDate) {
        this.title = title;
        this.dueDate = dueDate;
    }
    /*---------------- Getters&Setters ----------------*/

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getCompletedAt() {
        return completedAt;
    }

    public void setCompletedAt(LocalDateTime completedAt) {
        this.completedAt = completedAt;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate duedate) {
        this.dueDate = duedate;
    }

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    private String formatDuration(Duration duration) {
        if (duration == null) return "null";

        long totalSeconds = duration.getSeconds();
        long minutes = totalSeconds / 60;
        long seconds = totalSeconds % 60;

        return minutes + " min " + seconds + " sec";
    }


    /*---------------- toString ----------------*/

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", completed=" + completed +
                ", createdAt=" + createdAt +
                ", completedAt=" + completedAt +
                ", duedate=" + dueDate +
                ", duration=" + duration +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return Objects.equals(id, task.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }


}
