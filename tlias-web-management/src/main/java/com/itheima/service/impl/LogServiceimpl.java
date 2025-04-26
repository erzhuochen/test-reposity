package com.itheima.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.mapper.LogMapper;
import com.itheima.pojo.Emp;
import com.itheima.pojo.Log;
import com.itheima.pojo.PageResult;
import com.itheima.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogServiceimpl implements LogService {

    @Autowired
    private LogMapper logMapper;

    @Override
    public PageResult<Log> page(Integer page, Integer pageSize) {
        PageHelper.startPage(page, pageSize);

        //这边接收到的其实就是Page<Emp>对象
        List<Log> logList = logMapper.findAll();

        Page<Log> p = (Page<Log>) logList;

        return new PageResult<Log>(p.getTotal(),p.getResult());
    }
}
