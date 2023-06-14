package com.example.todospringbootdemo.dto;

import lombok.Data;

@Data
public class CreateToDoDto {
    private String name;
    private Boolean completed;
}