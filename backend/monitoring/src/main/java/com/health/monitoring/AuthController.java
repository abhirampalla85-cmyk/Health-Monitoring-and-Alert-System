package com.health.monitoring;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserRepository repo;

    @PostMapping("/signup")
    public String signup(@RequestBody User user){
        repo.save(user);
        return "Registered";
    }

    // ✅ FIXED LOGIN
    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody User user){

        Map<String, Object> response = new HashMap<>();

        User existing = repo.findByEmailAndPassword(
                user.getEmail(),
                user.getPassword()
        );

        if(existing != null){
            response.put("status", "Success");
            response.put("id", existing.getId());   // ✅ VERY IMPORTANT
            response.put("username", existing.getUsername());
        } else {
            response.put("status", "Invalid");
        }

        return response;
    }
}