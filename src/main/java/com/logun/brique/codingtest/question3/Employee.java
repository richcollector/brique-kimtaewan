package com.logun.brique.codingtest.question3;

import com.logun.brique.codingtest.mapper.EmployeeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/employee/api")
@RequiredArgsConstructor
public class Employee {
    private final EmployeeMapper employeeMapper;

    @RequestMapping("/list")
    public ModelAndView employeeList() {

        ModelAndView mav = new ModelAndView("/question/question3");
        mav.addObject("employeeList", employeeMapper.employeeList());
        System.out.println(employeeMapper.employeeList());

        return mav;
    }

}