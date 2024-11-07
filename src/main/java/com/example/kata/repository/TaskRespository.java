package com.example.kata.repository;

import com.example.kata.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRespository extends JpaRepository<Task,Integer> {
}
