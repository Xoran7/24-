package org.example.app00.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.app00.entity.Department;

import java.util.List;

@Mapper // 标记为持久层
public interface DepartmentMapper {

    List<Department> selectDepart();
}
