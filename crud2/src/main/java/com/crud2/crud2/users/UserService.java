package com.crud2.crud2.users;

import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public ResponseEntity<Object> getUsers() {
        JSONObject response = new JSONObject();

        try {
            List<User> users = userRepository.findAll();

            response.put("data", users);

            return ResponseEntity.status(HttpStatus.OK).body(response.toString());
        } catch (Exception e) {
            response.put("message", "Error al listar los usuarios");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response.toString());
        }
    }

}
