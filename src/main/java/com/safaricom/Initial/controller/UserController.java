package com.safaricom.Initial.controller;

import com.safaricom.Initial.model.User;
import com.safaricom.Initial.service.UserService;
import com.safaricom.Initial.util.ResponseObject;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("api/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping("/add")
    public ResponseObject addUser(@Validated @RequestBody User user) {
        return new ResponseObject(userService.addUser(user), 200, "successfully added");
    }

    @GetMapping("/view")
    public ResponseObject getUser(@RequestParam("userID") Integer userID) {
        try {
            return new ResponseObject(userService.viewUser(userID), 200, "");
        } catch (Exception e) {
            return new ResponseObject(null, 404, e.getMessage());
        }
    }

    @PostMapping("/upload")
    public ResponseObject uploadUserImage(@RequestParam("file") MultipartFile file, @RequestParam("userID") Integer userID) {
        try {
            return new ResponseObject(userService.updateUserImage(file, userID), 200, "File uploaded successfully");
        } catch (Exception e) {
            return new ResponseObject(null, 404, e.getMessage());
        }
    }

    @GetMapping("/file")
    public ResponseObject getUserImage(@RequestParam("userID") Integer userID) {
        try {
            return new ResponseObject(userService.getUserImage(userID), 200, "");
        } catch (Exception e) {
            return new ResponseObject(null, 404, e.getMessage());
        }
    }

    @GetMapping("/viewAll")
    public ResponseObject getAllUsers() {
        return new ResponseObject(userService.getAllUsers(), 200, "");
    }

    @DeleteMapping("/delete")
    public ResponseObject deleteUser(@RequestParam("userID") Integer userID) {
        try {

            return new ResponseObject(userService.deleteUser(userID.longValue()), 200, "successfully deleted");
        } catch (Exception e) {
            return new ResponseObject(null, 404, e.getMessage());
        }


    }

    @PutMapping("/update")
    public ResponseObject updateUser(@Validated @RequestBody User user) {
        try {
            return new ResponseObject(userService.updateUser(user), 200, "successfully updated");
        } catch (Exception e) {
            return new ResponseObject(null, 404, e.getMessage());
        }

    }


}
