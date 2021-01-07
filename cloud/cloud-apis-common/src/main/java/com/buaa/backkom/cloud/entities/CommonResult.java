package com.buaa.backkom.cloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: backkom
 * @Date: 2020/9/12 11:59
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T>
{
    private Integer code;
    private String message;
    private T     data;
    
    public CommonResult (Integer code, String message) {
        this(code,message,null);
    }
}
