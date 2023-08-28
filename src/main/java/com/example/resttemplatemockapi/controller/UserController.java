package com.example.resttemplatemockapi.controller;

import com.example.resttemplatemockapi.DTO.UserDTO;
import com.example.resttemplatemockapi.Service.UserService;
import com.example.resttemplatemockapi.Service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping
    public ResponseEntity<List<UserDTO>>getAll(){
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> saveUser(@RequestBody UserDTO userDTO){
        userService.saveUser(userDTO);
        return ResponseEntity.ok("El usuario ha sido guardado");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String>  updateUser(@PathVariable Long id, @RequestBody UserDTO userDTO){
        userService.updateUser(id,userDTO);
        return ResponseEntity.ok ("El usuario ha sido actualizado");
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return ResponseEntity.ok ("El usuario ha sido eliminado");
    }

}
