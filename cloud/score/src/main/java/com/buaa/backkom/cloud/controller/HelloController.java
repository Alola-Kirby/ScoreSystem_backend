package com.buaa.backkom.cloud.controller;

import com.buaa.backkom.cloud.entities.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class HelloController {
    @GetMapping("/score/{id}")
    public CommonResult create(@PathVariable("id") Long id) {
        log.info("********id:"+id);
        return new CommonResult(id.intValue(),"Hello");
    }
}
