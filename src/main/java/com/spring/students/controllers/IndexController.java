package com.spring.students.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/students")
    public String students() {
        return "students";
    }

    @GetMapping("/specialties")
    public String specialties() {
        return "specialties";
    }

    @GetMapping("/faculties")
    public String faculties() {
        return "faculties";
    }

    @GetMapping("/report")
    public String report() {
        return "report";
    }
}
