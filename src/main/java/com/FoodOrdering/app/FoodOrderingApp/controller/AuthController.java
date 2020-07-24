package com.FoodOrdering.app.FoodOrderingApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.FoodOrdering.app.FoodOrderingApp.config.JwtProvider;
import com.FoodOrdering.app.FoodOrderingApp.repository.ClientRepository;
import com.FoodOrdering.app.FoodOrderingApp.service.impl.AuthenticationServiceImpl;
import com.FoodOrdering.app.FoodOrderingApp.service.impl.CustomeUserDetailsService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/auth")
public class AuthController {

	@Autowired
	AuthenticationServiceImpl authService;

    @Autowired
    ClientRepository client;


    
	// Example URL :
	// http://localhost:8080/api/user/login?email_login=hchab&Password=pass123
	@RequestMapping(value = "/login",
			params = { "email","password" },
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity login(@RequestParam("email") String email , @RequestParam("password") String password ) {
		return authService.login(email, password);
    }

//    @SuppressWarnings("rawtypes")
//    @PostMapping("/register")
//    public ResponseEntity register(@RequestBody User user) {
//        User userExists = userService.findUserByEmail(user.getEmail());
//        if (userExists != null) {
//            throw new BadCredentialsException("User with username: " + user.getEmail() + " already exists");
//        }
//        userService.saveUser(user);
//        Map<Object, Object> model = new HashMap<>();
//        model.put("message", "User registered successfully");
//        return ok(model);
//    }

}
