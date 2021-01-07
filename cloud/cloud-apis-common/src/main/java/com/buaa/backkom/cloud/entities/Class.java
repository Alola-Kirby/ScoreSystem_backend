package com.buaa.backkom.cloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Class {
    private Long class_id;
    private Long teacher_id;
    private String name;
}
