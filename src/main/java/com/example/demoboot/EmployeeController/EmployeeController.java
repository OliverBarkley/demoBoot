package com.example.demoboot.EmployeeController;

import com.example.demoboot.EmployeeService.EmployeeService;
import com.example.demoboot.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller

public class EmployeeController {
    private final EmployeeService employeeService;
    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @GetMapping(value = "users/add")
    public String addUser(Model model) {
        Employee employee = new Employee();
        model.addAttribute("user", employee);
        return "addEmployee";

    }

    @PostMapping(value = "users/add")
    public String addUser(@ModelAttribute("user") Employee employee) {
        employeeService.addEmployee(employee);
        return "redirect:/users";
    }




    @GetMapping(value = "users/edit/{id}")
    public String editUser(ModelMap model, @PathVariable("id") int id) {
        Employee employee = employeeService.getEmployeeById(id);
        model.addAttribute("user", employee);
        return "editEmployee";
    }

    @PostMapping(value = "users/edit")
    public String edit(@ModelAttribute("user") Employee employee) {
        employeeService.editEmployee(employee);
        return "redirect:/users";
    }


    @GetMapping("users/{id}")
    public String show(@PathVariable("id") int id, ModelMap modelMap) {
        modelMap.addAttribute("user", employeeService.getEmployeeById(id));
        return "show";
    }

    @GetMapping(value = "users")
    public String allUsers(ModelMap model) {
        model.addAttribute("users", employeeService.getAllEmployees());
        return "users";
    }

    @GetMapping("users/delete")
    public String deleteUserById(@RequestParam("id") int id) {
        employeeService.deleteEmployee(id);
        return "redirect:/users";
    }




}
