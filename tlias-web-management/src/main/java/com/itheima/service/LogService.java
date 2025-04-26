package com.itheima.service;

import com.itheima.pojo.Log;
import com.itheima.pojo.PageResult;

public interface LogService {
    PageResult<Log> page(Integer page, Integer pageSize);
}
