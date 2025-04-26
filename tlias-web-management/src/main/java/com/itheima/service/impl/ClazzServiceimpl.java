package com.itheima.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.mapper.ClazzMapper;
import com.itheima.mapper.StudentMapper;
import com.itheima.pojo.Clazz;
import com.itheima.pojo.ClazzQueryParam;
import com.itheima.pojo.Emp;
import com.itheima.pojo.PageResult;
import com.itheima.service.ClazzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


@Service
public class ClazzServiceimpl implements ClazzService {

    @Autowired
    private ClazzMapper clazzMapper;

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public PageResult<Clazz> page(ClazzQueryParam clazzQueryParam) {
        PageHelper.startPage(clazzQueryParam.getPage(), clazzQueryParam.getPageSize());

        //这边接收到的其实就是Page<Emp>对象
        List<Clazz> clazzList = clazzMapper.list(clazzQueryParam);
        clazzList.forEach(x ->{
            LocalDate beginDate = x.getBeginDate();
            LocalDate endDate = x.getEndDate();
            LocalDate now = LocalDate.now();
            if(now.isBefore(beginDate)) x.setStatus("未开班");
            else if(now.isBefore(endDate)) x.setStatus("已开班");
            else x.setStatus("已结课");
        });

        Page<Clazz> p = (Page<Clazz>) clazzList;

        return new PageResult<Clazz>(p.getTotal(),p.getResult());
    }

    @Override
    public void delete(Integer id) {
        clazzMapper.delete(id);
        studentMapper.deleteByclazzId(id);
    }

    @Override
    public void insert(Clazz clazz) {
        clazz.setUpdateTime(LocalDateTime.now());
        clazz.setCreateTime(LocalDateTime.now());
        clazzMapper.insert(clazz);
    }

    @Override
    public Clazz selectById(Integer id) {
        return clazzMapper.selectById(id);
    }

    @Override
    public void update(Clazz clazz) {
        clazz.setUpdateTime(LocalDateTime.now());
        clazzMapper.update(clazz);
    }

    @Override
    public List<Clazz> findAll() {
        return clazzMapper.findAll();
    }
}
