package com.su.enjoy.mapper.user;

import com.su.enjoy.model.user.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserRepository {
    User findByEmail(String email);

    /** Userデータ全て取得 */
    List<User> findAll();
}
