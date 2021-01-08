package com.buaa.backkom.cloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Score {
    private String stu_id;
    private String class_id;
    private Double score;
    private String stu_name;
    private String class_name;
}
