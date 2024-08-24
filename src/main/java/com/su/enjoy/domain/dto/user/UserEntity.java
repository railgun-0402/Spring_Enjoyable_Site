package com.su.enjoy.domain.dto.user;

import lombok.Data;

/**
 * データアクセスのために使われるDTO
 */
@Data
public class UserEntity {
    private int id;
    private String name;
    private String password;
    private int coin;
}
