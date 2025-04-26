package com.itheima.controller;

import com.itheima.anno.Log;
import com.itheima.pojo.Dept;
import com.itheima.pojo.Result;
import com.itheima.service.DeptService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//一个完整的请求路径=类上+方法上的
@RequestMapping("/depts")
@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;

//    @RequestMapping(value = "/depts",method = RequestMethod.GET)
    @GetMapping
    @Log
    public Result list(){
        System.out.println("查询全部数据");
        List<Dept> deptList = deptService.findAll();
        return Result.success(deptList);
    }

    @Log
    @DeleteMapping
    public Result delete(Integer id){
//        String idStr = request.getParameter("id");
//        int id = Integer.parseInt(idStr);
        System.out.println("根据ID删除部门：" + id);
        deptService.deleteById(id);
        return Result.success();
    }

    @Log
    @PostMapping
    public Result add(@RequestBody Dept dept){
        deptService.add(dept);
        System.out.println(123);
        return Result.success();
    }

    @Log
    @GetMapping("/{id}")
    public Result getInfo(@PathVariable Integer id){
        System.out.println(id);
        Dept dept = deptService.getById(id);
        return Result.success(dept);
    }

    @Log
    @PutMapping
    public Result update(@RequestBody Dept dept){
        deptService.update(dept);
        return Result.success();
    }
}
