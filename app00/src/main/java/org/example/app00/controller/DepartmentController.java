package org.example.app00.controller;

import org.example.app00.entity.Department;
import org.example.app00.service.DepartmentService;
import org.example.app00.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController // 标记当前为控制层
@RequestMapping("department")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService; // 编译看左，运行看右？

    /*
    查询组织列表
     */

    @GetMapping("selectDepartment")
    public Result<List<Department>> getDepartments() {
        List<Department> departments = departmentService.selectDepartment();
        return Result.success("查询成功", departments);
    }
}
