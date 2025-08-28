package com.app.FinanceManagement.Controller;

import com.app.FinanceManagement.DTO.UserDTO;
import com.app.FinanceManagement.Service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequestMapping("/api/users")
public class UserController{

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    //Endpoint to get all users / Punto final para obtener todos los usuarios

    @GetMapping("/all")
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        List<UserDTO> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    //Endpoint to create a new user / Punto final para crear un nuevo usuario

    @PostMapping("/create")
    public ResponseEntity<UserDTO> createUser(@Validated @RequestBody UserDTO userDTO) {
        UserDTO created = userService.createUser(userDTO);
        return ResponseEntity.ok(created);
    }
    //Endpoint to update a user / Punto final para actualizar un usuario
    @PutMapping("/update/{id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable Long id, @Validated @RequestBody UserDTO userDTO) {
        UserDTO updatedUser = userService.updateUser(id, userDTO);
        return ResponseEntity.ok(updatedUser);
    }
    //Endpoint to disable (soft delete) a user / Punto final para deshabilitar un usuario
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> disableUser(@PathVariable Long id) {
        userService.disableUser(id);
        return ResponseEntity.noContent().build();
    }

    //Endpoint to enable a user / Punto final para habilitar un usuario
    @PutMapping("/{id}/enable")
    public ResponseEntity<UserDTO> enable(@PathVariable Long id) {
        return ResponseEntity.ok(userService.enableUser(id));
    }

    //Endpoint to disable a user / Punto final para deshabilitar un usuario
    @PutMapping("/{id}/disable")
    public ResponseEntity<UserDTO> disable(@PathVariable Long id) {
        return ResponseEntity.ok(userService.disableUser(id));
    }

    //Endpoint to get a user by id / Punto final para obtener un usuario por id
    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Long id) {
        UserDTO user = userService.getUserById(id);
        return ResponseEntity.ok(user);
    }

    // === vistas Thyleaf === (prefijo/users) ===

    @GetMapping("/users/list") //listar
    public String ListUsersView(Model model){
        model.addAttribute("users", userService.getAllUsers());
        return "users/list";
    }

    @GetMapping("/users/new") //crear (mostrar formulario)
    public String showCreateUserForm(Model model){
        model.addAttribute("user", new UserDTO());
        return "users/new";
    }

    @GetMapping("/users/edit/{id}") //editar
    public String showEditUserForm(@PathVariable Long id, Model model) {
        UserDTO user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "users/edit";
    }

}
