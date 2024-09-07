package com.su.enjoy.controller.home;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    // ホーム画面遷移時は何もしない
    @GetMapping("/")
    public void index() {
    }
}
