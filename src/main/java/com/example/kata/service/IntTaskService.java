package com.example.kata.service;

import com.example.kata.entity.Task;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface IntTaskService {

    public List<Task> findAll();

    public Task saveTask(Task task);

    public Optional<Task> findTask(int id);

    public void deleteTask(int id);
}
