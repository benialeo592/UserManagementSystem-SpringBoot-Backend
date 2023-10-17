package com.leone.ums.service;

import com.leone.ums.dto.ResponseMessage;
import com.leone.ums.dto.UserUpdateRequest;
import com.leone.ums.entity.User;
import com.leone.ums.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {

    private UserRepository userRepo;

    public List<User> getAllUsers(){
        return this.userRepo.findAll();
    }

    public User getUserById(Long id){
        Optional<User> foundUser = this.userRepo.findById(id);
        if(foundUser.isEmpty()){
            throw new NoSuchElementException("User not found");
        }
        return foundUser.get();
    }

    public User saveUser(User user){
        return this.userRepo.save(user);
    }

    public User updateUser(UserUpdateRequest request, Long id){
        Optional<User> foundUser = this.userRepo.findById(id);
        if(foundUser.isEmpty()){
            throw new NoSuchElementException("User not found");
        }
        foundUser.get().setFirstname(request.getFirstname());
        foundUser.get().setLastname(request.getLastname());
        foundUser.get().setEmail(request.getEmail());
        foundUser.get().setCompany(request.getCompany());
        foundUser.get().setRole(request.getRole());
        return this.userRepo.save(foundUser.get());
    }

    public ResponseMessage deleteUser(Long id) {
        Optional<User> foundUser = this.userRepo.findById(id);
        if(foundUser.isEmpty()){
            throw new NoSuchElementException("User not found");
        }
        this.userRepo.deleteById(id);
        return new ResponseMessage("User deleted");
    }
}
