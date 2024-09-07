package com.su.enjoy.mapper.user;

import com.su.enjoy.model.user.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserRepository {
    public User findByEmail(String email);
}
