package com.nepenthe.controller;

import cn.hutool.json.JSONUtil;
import com.nepenthe.pojo.Students;
import com.nepenthe.service.StudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author goodsir
 */
@RestController
@RequestMapping(value = "/Student")
@Api(tags = "学生相关接口")
public class StudentController {
    /**
     * controller 调 service层
     */
    @Autowired
    @Qualifier("studentServiceImpl")
    private StudentService studentService;

    /**
     * 查询全部的学生,并且返回到一个学生展示页面
     */
    @GetMapping("/allStudent")
    @ApiOperation(value = "查询全部用户信息", httpMethod = "GET", notes = "查询全表学生")
    @ResponseBody
    public String list(Model model, HttpServletResponse res) {
        res.setContentType("application/json; charset=UTF-8");
        List<Students> students = studentService.queryAllStudent();
        return JSONUtil.toJsonStr(students);
    }

    /**
     * @return 添加学生的请求
     */
    @RequestMapping("addStudent")
    @ApiOperation(value = "添加用户", httpMethod = "POST", notes = "添加新用户")
    public String addStudent(Students students) {
        System.out.println("Students = " + students);
        studentService.addStudent(students);
        //重定向到我们的@RequestMapping("/allStudent")请求;
        return "redirect:/Student/allStudent";
    }

    /**
     * @return 修改学生
     */
    @RequestMapping("/updateStudent")
    @ApiOperation(value = "修改学生信息", httpMethod = "POST", notes = "修改学生信息")
    public String updateStudent(Students students) {
        System.out.println("Students = " + students);
        studentService.updateStudent(students);
        return "redirect:/Student/allStudent";
    }

    /**
     * @param id
     * @return 根据id删除学生
     */
    @RequestMapping("/deleteStudent/{id}")
    @ApiOperation(value = "根据id删除学生", httpMethod = "GET", notes = "删除学生")
    public String deleteStudent(@PathVariable("id") int id) {
        studentService.deleteStudent(id);
        return "redirect:/Student/allStudent";
    }

    /*
     * @return 通过id查询学生
     */

    @RequestMapping("/queryStudent/{id}")
    @ApiOperation(value = "根据id查询学生", httpMethod = "GET", notes = "根据id查询学生")
    public String queryStudent(@PathVariable("id") int id) {
        Students students = studentService.queryStudentById(id);
        return JSONUtil.toJsonStr(students);

    }
}