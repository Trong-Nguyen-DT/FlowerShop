package com.example.admin.Controller;


import com.example.admin.Entity.UserEntity;
import com.example.admin.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;

@Controller
@RequestMapping
public class LoginController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/login")
    public String loginAdmin(Model model) {
        model.addAttribute("user", new UserEntity());
//        UserEntity user = new UserEntity();
//        user.setUsername("staff");
//        user.setPassword(passwordEncoder.encode("12345"));
//        userRepository.save(user);
        return "Login";
    }

}
