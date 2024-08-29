package com.example.WeatherResuelto.Controller;

import com.example.WeatherResuelto.Common.Request.UserRegister;
import com.example.WeatherResuelto.Service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Users")
public class UserController {

    private final IUserService _userService;

    @Autowired
    public UserController(IUserService userService){
        this._userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> UserRegister(@RequestBody UserRegister register) {
        String response = _userService.UserRegister(register);
        return ResponseEntity.ok(response);
    }
}
