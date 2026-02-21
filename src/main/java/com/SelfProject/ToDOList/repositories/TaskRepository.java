package com.SelfProject.ToDOList.repositories;

import com.SelfProject.ToDOList.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Integer> {
    //5.Show Specific task
    public Task findTaskById(Long id);
    //5.Show All tasks
    public List<Task> findAll();
    //7.Show all completed tasks
    public List<Task> findByCompletedTrue();
    //7.Show all not completed tasks
    public List<Task> findByCompletedFalse();
}
