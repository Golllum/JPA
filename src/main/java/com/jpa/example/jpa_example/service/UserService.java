package com.jpa.example.jpa_example.service;


import com.jpa.example.jpa_example.model.User;
import com.jpa.example.jpa_example.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    public User save(User user){
        if(user.getUserId().isEmpty()){
            throw new EntityNotFoundException("UserId is essential!");
        }

        return userRepository.save(user);
    }

    public void delete(String id){
        userRepository.deleteById(id);
    }

    public User readById(String id){
        Optional<User> user = userRepository.findById(id);

        if(!user.isPresent()){
            throw new EntityNotFoundException("User Not Found!");
        }

        return user.get();
    }

    public List<User> readByUserName(String userName) {
        List<User> user = userRepository.findUserByUserName(userName);

        if(user.isEmpty()){
            throw new EntityNotFoundException("User Not Found!");
        }

        return user;
    }

    public User update(User user){
        if(user.getUserId().isEmpty()){
            throw new EntityNotFoundException("UserId is essential!");
        }

        Optional<User> optionalUser = userRepository.findById(user.getUserId());

        if(!optionalUser.isPresent()){
            throw new EntityNotFoundException("User Not Found!");
        }

        return userRepository.save(user);
    }


}
