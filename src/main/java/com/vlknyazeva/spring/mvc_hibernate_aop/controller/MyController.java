package com.vlknyazeva.spring.mvc_hibernate_aop.controller;

import com.vlknyazeva.spring.mvc_hibernate_aop.entity.Employee;
import com.vlknyazeva.spring.mvc_hibernate_aop.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MyController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/")
    public String showAllEmployees(Model model) {
        List<Employee> allEmployees = employeeService.getAllEmployees();
        model.addAttribute("allmps", allEmployees);

        return "all-employees";
    }

    @RequestMapping("/addNewEmployee")
    public String addNewEmployee(Model model) {

        Employee employee = new Employee(); //экз без агрементов, чтобы во вью создался новый работник без данных, для их последубщего заполнения
        model.addAttribute("employee", employee);

        return "empl-info";
    }

    @RequestMapping("/saveEmployee")
    // получаем из view артибут 'employee',а это employee  с уже заполненными данными, вызываем метод saveEmployee
    // из Service, кот в свою очередь сохраняет данные работника в EmployeeDAO
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {

        employeeService.saveEmployee(employee);

        return "redirect:/"; //перенаправление на список работникоов, т.е. метод showAllEmployees
    }

    @RequestMapping("/updateInfo")
    public String updateEmployee(@RequestParam("empId") int id,
                                 Model model) { //аннотация присв-т значению id айди работника
        Employee employee = employeeService.getEmployee(id); //получаем работника с бд по его id
        model.addAttribute("employee", employee); // имя атрибута обяз такое же, как и в методе addNewEmployee выше

        return "empl-info";
    }

    @RequestMapping("/deleteEmployee")
    public String deleteEmployee(@RequestParam("empId") int id) {
        employeeService.deleteEmployee(id);

        return "redirect:/";
    }
}
