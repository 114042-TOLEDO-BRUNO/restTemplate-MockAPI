package com.example.resttemplatemockapi.Service;

import com.example.resttemplatemockapi.DTO.UserDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    public List<UserDTO> getAllUsers();
    public void saveUser(UserDTO userDTO);
    public void updateUser(Long id,UserDTO userDTO);
    public void deleteUser(Long id);
}
