package com.nepenthe.service;

import com.nepenthe.dao.StudentMapper;
import com.nepenthe.pojo.Students;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author goodsir
 */
@Service
public class StudentServiceImpl implements StudentService {

    /**
     * service调dao层:组合dao层
     */
    private StudentMapper studentMapper;

    public void setStudentMapper(StudentMapper studentMapper) {
        this.studentMapper = studentMapper;
    }

    @Override
    public int addStudent(Students student) {
        return studentMapper.addStudent(student);
    }

    @Override
    public int deleteStudent(int id) {
        return studentMapper.deleteStudent(id);
    }

    @Override
    public int updateStudent(Students students) {
        return studentMapper.updateStudent(students);
    }

    @Override
    public Students queryStudentById(int id) {
        return studentMapper.queryStudentById(id);
    }

    @Override
    public List<Students> queryAllStudent() {
        return studentMapper.queryAllStudent();
    }

    @Override
    public Students queryStudentByName(String name) {
        return studentMapper.queryStudentByName(name);
    }

    public StudentMapper getStudentMapper() {
        return studentMapper;
    }
}
