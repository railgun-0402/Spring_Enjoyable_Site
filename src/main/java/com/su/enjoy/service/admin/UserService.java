package com.su.enjoy.service.admin;

import com.su.enjoy.mapper.user.UserRepository;
import com.su.enjoy.model.user.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Userデータの一覧(SELECT)
     */
    public List<User> list() {
        return userRepository.findAll();
    }
}
