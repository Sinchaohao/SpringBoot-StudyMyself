package com.hunau.springbootcrud.controller;

import com.hunau.springbootcrud.dao.DepartmentDao;
import com.hunau.springbootcrud.dao.EmployeeDao;
import com.hunau.springbootcrud.entities.Department;
import com.hunau.springbootcrud.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    DepartmentDao departmentDao;

    @GetMapping("/emps")
    public String list(Model model){
        Collection<Employee> employees = employeeDao.getAll();
        //放在请求域中
        model.addAttribute("emps",employees);

        return "emp/list.html";
    }

    @GetMapping("/emp")
    public String addEmp(Model model){

        return "emp/add";
    }
}
