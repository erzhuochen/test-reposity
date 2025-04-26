package com.itheima.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Log {
    private Integer id;
    private Integer operateEmpId;
    private String operateTime;
    private String className;
    private String methodName;
    private String methodParams;
    private String returnValue;
    private Integer costTime;
    private String operateEmpName;
}
