package com.example.demo.controllers;

import com.example.demo.daos.CourseDAO;
import com.example.demo.daos.EmployeeDAO;
import com.example.demo.daos.JobDAO;
import com.example.demo.daos.ProfileDAO;
import com.example.demo.models.Course;
import com.example.demo.models.Employee;
import com.example.demo.models.Job;
import com.example.demo.models.Profile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Set;

@Controller
public class PageController {

    @Autowired
    ProfileDAO profileDAO;

    @Autowired
    EmployeeDAO employeeDAO;

    @Autowired
    JobDAO jobDAO;

    @Autowired
    CourseDAO courseDAO;

    @GetMapping("/")
    public String getIndex(Model model) {
        model.addAttribute("profile", profileDAO.findAll());
        model.addAttribute("employee", employeeDAO.findAll());
        model.addAttribute("job", jobDAO.findAll());
//        employee.forEach(e->{
//            e.getCourses().forEach(a->{
//                System.out.println(e.getProfile().getName());
//                System.out.println(a.getName());
//            });
//        });
        return "index";
    }

    @GetMapping("/employee")
    public String getEmployee() {
        return "employee";
    }

    @PostMapping("/employee")
    public String postEmployee(Employee employee, Profile profile) {
        profileDAO.save(profile);
        employee.setProfile(profile);
        employeeDAO.save(employee);
        return "redirect:/";
    }

    @GetMapping("/job")
    public String getJob(Model model) {
        model.addAttribute("employee", employeeDAO.findAll());
        return "job";
    }

    @PostMapping("/job")
    public String postJob(Job job) {
        jobDAO.save(job);
        return "redirect:/";
    }

    @GetMapping("/train")
    public String getTrain(Model model) {
        model.addAttribute("employee", employeeDAO.findAll());
        model.addAttribute("course", courseDAO.findAll());
        return "train";
    }

    @PostMapping("/train")
    public String postTrain(Employee employee, @RequestParam("course") Set<Course> courses) {
        employee.setCourses(courses);
        courses.forEach(e -> {
            e.getEmployees().add(employee);
        });
        employeeDAO.save(employee);
        return "redirect:/";
    }

    @GetMapping("/course")
    public String getCourse() {
        return "course";
    }

    @PostMapping("/course")
    public String postCourse(Course course) {
        courseDAO.save(course);
        return "redirect:/";
    }

    @PostMapping("/show")
    public String postShow(@RequestParam int id, Model model) {
        Employee employee = employeeDAO.findById(id).orElse(null);
        model.addAttribute("name", employee.getProfile().getName());
        model.addAttribute("course", employee.getCourses());
        return "show";
    }
}