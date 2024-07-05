package org.example.app00.service.impl;

import org.example.app00.entity.Department;
import org.example.app00.mapper.DepartmentMapper;
import org.example.app00.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // 标记为业务层, 实际上是放进spring容器中
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentMapper departmentMapper;

    @Override
    public List<Department> selectDepartment() {
        List<Department> departments = departmentMapper.selectDepart();
        if (departments == null || departments.isEmpty()) {
            throw new RuntimeException("当前没有组织数据");
        }

        return departments; // 返回给controller
    }

}
