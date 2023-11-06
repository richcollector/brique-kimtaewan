package com.logun.brique.codingtest.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;
@Mapper
public interface EmployeeMapper {
    List<Map<String, Object>> employeeList();
}
