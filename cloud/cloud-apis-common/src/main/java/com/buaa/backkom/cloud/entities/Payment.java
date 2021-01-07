package com.buaa.backkom.cloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: backkom
 * @Date: 2020/9/12 11:56
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment
{
    private Long id;
    private String serial;
}
