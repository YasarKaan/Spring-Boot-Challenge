package com.example.demo.controller;

import com.example.demo.model.TaskRequest;
import com.example.demo.model.TaskResponse;
import com.example.demo.service.TaskService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
@Api
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService){
        this.taskService=taskService;
    }

    @PostMapping("/createTask")
    public void createTask( @RequestBody TaskRequest taskRequest){
        taskService.createTask(taskRequest);
    }

    @GetMapping("/getTasks")
    public List<TaskResponse> getTaskList() {
        return taskService.getTodoTasks();
    }

    @DeleteMapping("/deleteTask")
    public void deleteTask(Long taskId) {taskService.deleteTask(taskId);}



}
