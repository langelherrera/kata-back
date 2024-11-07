package com.example.kata.restController;

import com.example.kata.entity.Task;
import com.example.kata.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/task")
@CrossOrigin(origins = "http://localhost:5173")
public class TaskRestController {

    @Autowired
    private TaskService taskService;

    @PostMapping
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> createTask(@Valid @RequestBody Task task, BindingResult result){
        if (result.hasErrors()) {
            return new ResponseEntity<>(result.getAllErrors().stream()
                    .map(error -> error.getDefaultMessage())
                    .collect(Collectors.joining(", ")), HttpStatus.BAD_REQUEST);
        }else{
            taskService.saveTask(task);
            return new ResponseEntity<>(task, HttpStatus.CREATED);
        }

    }

    @GetMapping
    public ResponseEntity<?> findTasks(){
        List<Task> tasks= taskService.findAll();
        return  new ResponseEntity<>(tasks,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<Void> deleteTask(@PathVariable(value = "id") int id){
        taskService.deleteTask(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
