package com.itheima.controller;


import com.itheima.pojo.PageResult;
import com.itheima.pojo.Result;
import com.itheima.pojo.Student;
import com.itheima.pojo.StudentQueryParam;
import com.itheima.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public Result page(StudentQueryParam studentQueryParam) {
        PageResult<Student> studentPageResult = studentService.page(studentQueryParam);
        return Result.success(studentPageResult);
    }

    @PostMapping
    public Result insert(@RequestBody Student student){
        studentService.insert(student);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result selectById(@PathVariable Integer id){
        if(id == null)
        {
            return Result.error("233");
        }
        Student student = studentService.selectById(id);
        return Result.success(student);
    }

    @PutMapping
    public Result update(@RequestBody Student student){
        studentService.update(student);
        return Result.success();
    }

    @DeleteMapping("/{ids}")
    public Result deletes(@PathVariable Integer[] ids){
        studentService.deletes(ids);
        return Result.success();
    }

    @PutMapping("/violation/{id}/{score}")
    public Result action(@PathVariable Integer id, @PathVariable Integer score){
        studentService.action(id, score);
        return Result.success();
    }

}
