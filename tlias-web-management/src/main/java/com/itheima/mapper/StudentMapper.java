package com.itheima.mapper;

import com.itheima.pojo.Student;
import com.itheima.pojo.StudentQueryParam;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

@Mapper
public interface StudentMapper {

    List<Student> page(StudentQueryParam studentQueryParam);

    @Delete("delete from student where clazz_id = #{id}")
    void deleteByclazzId(Integer id);

    void insert(Student student);

    @Select("select * from student " +
            "where id= #{id}")
    Student selectById(Integer id);

    void update(Student student);

    void deletes(Integer[] ids);

    @Update("update student set violation_count = violation_count+1, violation_score = violation_score + #{score} where id = #{id}")
    void action(Integer id, Integer score);

    List<Map> getStudent();
}
