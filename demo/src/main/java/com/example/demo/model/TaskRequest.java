package com.example.demo.model;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class TaskRequest {

    private Long id;
    private String description;
}
