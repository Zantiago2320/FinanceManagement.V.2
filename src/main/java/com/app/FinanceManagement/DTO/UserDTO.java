package com.app.FinanceManagement.DTO;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class UserDTO {
    private long idUser;
    private String name;
    private String email;
    private String password;
    private String role;
    private LocalDateTime createdAt;
    private LocalDateTime updateAt;
    private Boolean enabled;
}
