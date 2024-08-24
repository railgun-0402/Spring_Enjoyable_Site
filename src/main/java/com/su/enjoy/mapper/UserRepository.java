package com.su.enjoy.domain.repository.user;

import com.su.enjoy.domain.dto.user.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserRepository {

    @Select("select * from users where name = #{name}")
    public UserEntity findByName(String name);

}
