package com.SelfProject.ToDOList.services;

import com.SelfProject.ToDOList.model.Task;
import com.SelfProject.ToDOList.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class TaskService {

    private TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }
    // 1.Create Task
    public Task createTask(Task task) {
        return taskRepository.save(task);
    }
    // 2.Task Status
    public Task toggleTask(Long taskId) {
        Task task = getTaskById(taskId);
        task.setCompleted(!task.isCompleted());
        task.setCompletedAt(LocalDateTime.now());
        setTaskDuration(task);
        return taskRepository.save(task);
    }

    public void setTaskDuration(Task task) {
        Duration duration = Duration.between(task.getCreatedAt(),task.getCompletedAt());
        task.setDuration(duration);
    }
    // 3.Update Task
    public Task updateTask(Task task) {
        return taskRepository.save(task);
    }
    //4.Delete Task
    public void deleteTask(Long taskId) {
        Task task = getTaskById(taskId);
        taskRepository.delete(task);
    }
    //5.Show Specific Task
    public Task getTaskById(Long id) {
        return taskRepository.findTaskById(id);
    }
    
    public List<Task> getAllTasks(){
        return taskRepository.findAll();
    }


}
