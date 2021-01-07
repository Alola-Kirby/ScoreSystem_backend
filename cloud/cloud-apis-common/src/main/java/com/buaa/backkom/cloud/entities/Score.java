package com.buaa.backkom.cloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Score {
    private Long stu_id;
    private Long class_id;
    private Double score;
    private String stu_name;
    private String class_name;
}
