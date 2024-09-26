package com.su.enjoy.controller.admin;

import com.su.enjoy.mapper.admin.HotelRepository;
import com.su.enjoy.mapper.user.UserRepository;
import com.su.enjoy.model.hotel.Hotel;
import com.su.enjoy.model.user.User;
import com.su.enjoy.service.admin.HotelService;
import com.su.enjoy.service.admin.UserService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/admin/users")
public class AdminUserController {
    private final UserService userService;

    public AdminUserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * ユーザーの管理画面Top
     *
     * @return List<User>
     */
    @GetMapping
    public List<User> index() {
        return userService.list();
    }
}
