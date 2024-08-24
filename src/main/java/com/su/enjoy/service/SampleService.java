package com.su.enjoy.service;

import com.su.enjoy.domain.dto.user.UserEntity;
import com.su.enjoy.mapper.UserRepository;
import org.springframework.stereotype.Service;


@Service
public class SampleService {

    private final UserRepository userRepository;

    public SampleService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserEntity get(String name) {
        return this.userRepository.findByName(name);
    }
}
