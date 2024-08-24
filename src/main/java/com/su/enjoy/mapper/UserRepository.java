package com.su.enjoy.mapper;

import com.su.enjoy.domain.dto.user.UserEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserRepository {
    UserEntity findByName(String name);
}
