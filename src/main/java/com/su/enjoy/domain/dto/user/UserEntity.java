package com.su.enjoy.domain.dto.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * データアクセスのために使われるDTO
 */
@Getter
@Setter
@Data
@AllArgsConstructor
public class UserEntity {
    private int id;
    private String name;
    private String password;
    private int coin;
}
