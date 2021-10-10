package com.nepenthe.service;

import com.nepenthe.pojo.Students;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author goodsir
 */
public interface StudentService {
    /**
     * @return 增加一个学生
     */
    int addStudent( Students student);

    /**
     * @param id 序号
     * @return 删除学生信息
     */
    int deleteStudent(int id);

    /**
     * @param students 学生类
     * @return 更新学生信息
     */
    int updateStudent(Students students);

    /**
     * @param id 学生序号
     * @return 根据id查询学生
     */
    Students queryStudentById(int id);

    /**
     * @return 查询全部
     */
    List<Students> queryAllStudent();

    /**
     * @param name 学生名称
     * @return 通过名字查询学生
     */
    Students queryStudentByName(String name);
}

