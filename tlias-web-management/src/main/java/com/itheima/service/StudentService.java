package com.itheima.service;

import com.itheima.pojo.PageResult;
import com.itheima.pojo.Student;
import com.itheima.pojo.StudentQueryParam;

import java.util.List;

public interface StudentService {
    PageResult<Student> page(StudentQueryParam studentQueryParam);

    void insert(Student student);

    Student selectById(Integer id);

    void update(Student student);

    void deletes(Integer[] ids);

    void action(Integer id, Integer score);
}
