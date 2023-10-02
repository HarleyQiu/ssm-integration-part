package org.example.mapper;

import org.example.pojo.Employee;

import java.util.List;

/**
 * @author 21055
 * @description 针对表【t_emp】的数据库操作Mapper
 * @createDate 2023-10-02 14:33:31
 * @Entity org.example.pojo.TEmp
 */
public interface EmployeeMapper {
    List<Employee> queryList();
}




