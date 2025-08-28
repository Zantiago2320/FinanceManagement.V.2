package com.app.FinanceManagement.Impl;

// import jakarta.persistence.*;
import com.app.FinanceManagement.DTO.UserDTO;
import com.app.FinanceManagement.Entity.User;
import com.app.FinanceManagement.Repository.UserRepository;
import com.app.FinanceManagement.Service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public UserImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public UserDTO findAllUsers() {
        return null;
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<User> users = userRepository.findAllByEnabledTrue();
        return users.stream()
                .map(user -> modelMapper.map(user, UserDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO getUserById(Long userId) {
        User user = userRepository.findByIdAndEnabledTrue(userId)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));
        return modelMapper.map(user, UserDTO.class);
    }

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        if (userRepository.findByEmail(userDTO.getEmail()).isPresent()) {
            throw new RuntimeException("User with email " + userDTO.getEmail() + " already exists.");
        }
        User user = modelMapper.map(userDTO, User.class);
        user.setIdUser(null); // Asegura que el ID sea nulo para que la base de datos lo genere
        if (user.getCreatedAt() == null) user.setCreatedAt(LocalDateTime.now());
        user.setUpdateAt(LocalDateTime.now());
        if (user.getEnabled() == null) user.setEnabled(true);
        user = userRepository.save(user);
        return modelMapper.map(user, UserDTO.class);
    }

    @Override
    public UserDTO updateUser(Long userId, UserDTO userDTO) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        if (userDTO.getPassword() != null && !userDTO.getPassword().isBlank()) {
            user.setPassword(userDTO.getPassword());
        }
        if (userDTO.getRole() != null) {
            user.setRole(userDTO.getRole());
        }
        if (userDTO.getEnabled() != null) {
            user.setEnabled(userDTO.getEnabled());
        }
        user.setUpdateAt(LocalDateTime.now());
        User updatedUser = userRepository.save(user);
        return modelMapper.map(updatedUser, UserDTO.class);
    }

    @Override
    public boolean deleteUser(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));
        user.setEnabled(false);
        user.setUpdateAt(LocalDateTime.now());
        userRepository.save(user);
        return true;
    }

    @Override
    public UserDTO enableUser(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));
        user.setEnabled(true);
        user.setUpdateAt(LocalDateTime.now());
        return modelMapper.map(userRepository.save(user), UserDTO.class);
    }

    @Override
    public UserDTO disableUser(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));
        user.setEnabled(false);
        user.setUpdateAt(LocalDateTime.now());
        return modelMapper.map(userRepository.save(user), UserDTO.class);
    }
}
