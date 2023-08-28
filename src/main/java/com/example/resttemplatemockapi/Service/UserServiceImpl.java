package com.example.resttemplatemockapi.Service;

import com.example.resttemplatemockapi.Client.RestClientUsers;
import com.example.resttemplatemockapi.DTO.UserDTO;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Value("${spring.externalservice.base-url}")
    private String basePath;
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public List<UserDTO> getAllUsers() {
       UserDTO[] response= restTemplate.getForObject(basePath+"users",UserDTO[].class);
       return Arrays.asList(response);
    }

    @Override
    public void saveUser(UserDTO userDTO) {
        restTemplate.postForObject(basePath+"users",userDTO, UserDTO.class);

    }

    @Override
    public void updateUser(Long id, UserDTO userDTO) {
        restTemplate.put(basePath+"users/"+id,userDTO);

    }

    @Override
    public void deleteUser(Long id) {
        restTemplate.delete(basePath+"users/"+id);

    }
}
