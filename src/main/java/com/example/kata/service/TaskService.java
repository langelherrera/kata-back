package com.example.kata.service;

import com.example.kata.entity.Task;
import com.example.kata.repository.TaskRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService implements IntTaskService{

    @Autowired
    private TaskRespository taskRespository;


    @Override
    @Transactional(readOnly = true)
    public List<Task> findAll() {
        return (List<Task>) taskRespository.findAll();
    }

    @Override
    public Task saveTask(Task task) {
        return taskRespository.save(task);
    }

    @Override
    public Optional<Task> findTask(int id) {
        return taskRespository.findById(id);
    }

    @Override
    public void deleteTask(int id) {
        taskRespository.deleteById(id);
    }
}
