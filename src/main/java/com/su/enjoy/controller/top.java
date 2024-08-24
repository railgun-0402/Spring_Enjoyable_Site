package com.su.enjoy.domain.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class top {
    @GetMapping("/")
    public String index() {
        return "index";
    }
}
