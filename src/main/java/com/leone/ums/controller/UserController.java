package com.leone.ums.controller;

import com.leone.ums.dto.ResponseMessage;
import com.leone.ums.dto.UserUpdateRequest;
import com.leone.ums.entity.User;
import com.leone.ums.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1/users")

public class UserController {

    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> all(){
        return ResponseEntity.ok().body(this.userService.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getById(@PathVariable  Long id){
        System.out.print(id);
        return ResponseEntity.ok().body(this.userService.getUserById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<User> create(@RequestBody User user){
        return ResponseEntity.ok().body(this.userService.saveUser(user));
    }

    @DeleteMapping("/destroy/{id}")
    public ResponseEntity<ResponseMessage> destroy(@PathVariable Long id){
        return ResponseEntity.ok().body(this.userService.deleteUser(id));
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<User> create(@RequestBody UserUpdateRequest user, @PathVariable Long id){
        return ResponseEntity.ok().body(this.userService.updateUser(user, id));
    }
}
