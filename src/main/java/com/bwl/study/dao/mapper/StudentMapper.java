package com.bwl.study.dao.mapper;

import com.bwl.study.dao.BaseMapper;
import com.bwl.study.entity.dos.Student;
import com.bwl.study.entity.example.StudentExample;
import java.util.List;

public interface StudentMapper extends BaseMapper<Student, StudentExample, Integer> {

    /**
     * 根据输入的学生信息进行条件检索
     * 1. 当只输入用户名时， 使用用户名进行模糊检索；
     * 2. 当只输入邮箱时， 使用性别进行完全匹配
     * 3. 当用户名和性别都存在时， 用这两个条件进行查询匹配的用
     * @param student
     * @return
     */
    List<Student> selectByStudentSelective(Student student);

    /**
     * - 当 studen_id 有值时， 使用 studen_id 进行查询；
     * - 当 studen_id 没有值时， 使用 name 进行查询；
     * - 否则返回空
     */
    Student selectByIdOrName(Student record);

    /**
     * 根据输入的学生信息进行条件检索
     * 1. 当只输入用户名时， 使用用户名进行模糊检索；
     * 2. 当只输入邮箱时， 使用性别进行完全匹配
     * 3. 当用户名和性别都存在时， 用这两个条件进行查询匹配的用
     */
    List<Student> selectByStudentSelectiveWhereTag(Student student);
}