package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Base {


    @GetMapping("/games")
    public String getPage2()
    {
        return "";
    }

    @GetMapping("/admin_panel")
    public String getPage3()
    {
        return "";
    }

}
