package com.ameya.MobileAppAPI.controller;


import com.ameya.MobileAppAPI.documents.User;
import com.ameya.MobileAppAPI.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/auth", method = RequestMethod.POST)
    public Map<String, Boolean> authenticateUser(@RequestParam("email") final String email,
                                                 @RequestParam("passwordHash") final String passwordHash) {
        Optional<User> user = userRepository.findUserByEmail(email);
        if (user.isEmpty()) {
            return Collections.singletonMap("auth", Boolean.FALSE);
        }
        return Collections.singletonMap("auth", user.get().getPasswordHash().equals(passwordHash));
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public boolean createUser(@RequestParam("firstName") final String firstName,
                           @RequestParam("lastName") final String lastName,
                           @RequestParam("email") final String email,
                           @RequestParam("passwordHash") final String passwordHash) {
        if(userRepository.findUserByEmail(email).isPresent()){
            return false;// Cannot create an account beacuse email ID already taken
        }
        User newUser = new User();
        newUser.setFirstName(firstName);
        newUser.setLastName(lastName);
        newUser.setEmail(email);
        newUser.setPasswordHash(passwordHash);
        userRepository.save(newUser);
        return true;
    }

    @RequestMapping(value = "/delete")
    public boolean deleteUser(@RequestParam("email") final String email,
                              @RequestParam("passwordHash") final String passwordHash) {
        if(authenticateUser(email, passwordHash).equals(Boolean.TRUE)) {
            userRepository.deleteUserByEmail(email);
            return true;
        }
        return false;
    }
}
