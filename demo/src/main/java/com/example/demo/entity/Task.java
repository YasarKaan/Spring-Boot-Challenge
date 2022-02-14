package com.example.demo.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="task_table")
@NoArgsConstructor
@Getter
@Setter

public class Task {

    @Id
    private Long id;
    @Column(name = "description")
    private String description;
}
