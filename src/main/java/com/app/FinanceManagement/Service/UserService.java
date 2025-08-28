package com.app.FinanceManagement.Service;

import com.app.FinanceManagement.DTO.UserDTO;

import java.util.List;

public interface UserService {

    UserDTO findAllUsers();

    List<UserDTO> getAllUsers();

    UserDTO createUser(UserDTO userDTO);

    UserDTO getUserById(Long userId);

    UserDTO updateUser(Long userId, UserDTO userDTO);

    boolean deleteUser(Long userId);

    UserDTO enableUser(Long userId);

    UserDTO disableUser(Long userId);
}