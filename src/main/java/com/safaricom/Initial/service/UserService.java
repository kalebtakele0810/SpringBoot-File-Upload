package com.safaricom.Initial.service;

import com.safaricom.Initial.model.User;
import com.safaricom.Initial.repository.UserRepository;


import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.util.stream.Stream;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Stream<User> getAllUsers() {
        return userRepository.findAll().stream();
    }

    public User viewUser(Integer userId) throws Exception {
        if (!userRepository.existsById(userId.longValue())) {
            throw new Exception("User with id " + userId + " does not exists");
        }
        return userRepository.findById(userId.longValue()).orElse(new User());
    }


    public User addUser(User user) {

        return userRepository.save(user);
    }

    public User updateUser(User user) throws Exception {
        if (!userRepository.existsById(user.getId())) {
            throw new Exception("User with id " + user.getId() + " does not exists");
        }
        return userRepository.save(user);
    }

    public boolean deleteUser(Long userId) throws Exception {
        if (!userRepository.existsById(userId)) {
            throw new Exception("User with id " + userId + " does not exists");
        }
        userRepository.deleteById(userId);
        return true;
    }

    public User updateUserImage(MultipartFile file, Integer userId) throws Exception {
        if (!userRepository.existsById(userId.longValue())) {
            throw new Exception("User with id " + userId + " does not exists");
        }
        User user = userRepository.findById(userId.longValue()).orElse(new User());
        user.setImage(file.getBytes());
        return userRepository.save(user);
    }

    public File getUserImage(Integer userId) throws Exception {
        if (!userRepository.existsById(userId.longValue())) {
            throw new Exception("User with id " + userId + " does not exists");
        }
        User user = userRepository.findById(userId.longValue()).orElse(new User());

        File image = new File("attachment/" + userId + ".png");
        FileUtils.writeByteArrayToFile(image, user.getImage());

        return image;

    }
}
