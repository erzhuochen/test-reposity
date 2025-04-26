package com.itheima.controller;

import com.itheima.pojo.Log;
import com.itheima.pojo.PageResult;
import com.itheima.pojo.Result;
import com.itheima.service.LogService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/log")
public class LogController {

    @Autowired
    private LogService logService;

    @GetMapping("/page")
    public Result page(@RequestParam(defaultValue = "1")Integer page, @RequestParam(defaultValue = "10")Integer pageSize){
         PageResult<Log> pageResult = logService.page(page, pageSize);
         return Result.success(pageResult);
    }

}
