package com.SelfProject.ToDOList.controller;

import com.SelfProject.ToDOList.model.Task;
import com.SelfProject.ToDOList.services.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {

    private TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/api/v1/tasks")
    public ResponseEntity<List<Task>> reviveAllTasks() {
        return ResponseEntity.ok(taskService.getAllTasks());
    }

    @PostMapping("/api/v1/tasks")
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        System.out.println("Received task: " + task);
        System.out.println("ID before save: " + task.getId());
        return ResponseEntity.ok(taskService.createTask(task));

    }

    @DeleteMapping("/api/v1/tasks/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
    }
    @PostMapping("/api/v1/tasks/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id,@RequestBody Task task) {
        task.setId(id);
        return ResponseEntity.ok(taskService.createTask(task));
    }
    @GetMapping("/api/v1/tasks/{id}/toggle")
    public ResponseEntity<Task> toggleTaskStatus(@PathVariable Long id) {
        return ResponseEntity.ok(taskService.toggleTask(id));
    }



}
