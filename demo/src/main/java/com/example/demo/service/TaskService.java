package com.example.demo.service;

import com.example.demo.entity.Task;
import com.example.demo.exceptions.BusinessException;
import com.example.demo.exceptions.ErrorCode;
import com.example.demo.model.TaskRequest;
import com.example.demo.model.TaskResponse;
import com.example.demo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class TaskService {

    private final TaskRepository taskRepository;


    @Autowired
    public TaskService(TaskRepository taskRepository){
        this.taskRepository=taskRepository;
    }

   public void createTask(TaskRequest taskRequest){
       Task task = new Task();
       task.setId(taskRequest.getId());
       task.setDescription(taskRequest.getDescription());
       taskRepository.save(task);
   }

    public List<TaskResponse> getTodoTasks() {
        List<Task> tasks = taskRepository.findAll();
        return tasks.stream().map(TaskResponse::fromEntity).collect(Collectors.toList());
    }

    public void deleteTask(Long taskId){
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new BusinessException(ErrorCode.resource_missing, "Task does not exist!"));
        taskRepository.delete(task);
    }
}
