package com.example.demo.model;

import com.example.demo.entity.Task;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@Builder
public class TaskResponse {

    private Long id;
    private String description;

    public static TaskResponse fromEntity(Task task){
        return TaskResponse.builder().id(task.getId()).description(task.getDescription()).build();
    }
}
