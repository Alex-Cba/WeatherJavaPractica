package com.example.WeatherResuelto.Service.Imp;

import com.example.WeatherResuelto.Common.CustomException.AppException;
import com.example.WeatherResuelto.Common.Entity.User;
import com.example.WeatherResuelto.Common.Request.UserRegister;
import com.example.WeatherResuelto.Repository.UserRepository;
import com.example.WeatherResuelto.Service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService implements IUserService {

    private final UserRepository _userRepo;

    @Autowired
    public UserService(UserRepository userRepository){
        this._userRepo = userRepository;
    }

    @Override
    public String UserRegister(UserRegister register) {
        var checkUser = _userRepo.findbyEmail(register.getEmail());

        if(checkUser != null){
            throw new AppException("USER_ALREADY_EXISTS");
        }

        var newUser = new User();
        newUser.setSecret(UUID.randomUUID().toString());
        newUser.setEmail(register.getEmail());
        newUser.setPassword(register.getPassword());
        newUser.setFavTemperature(register.getFavTemperature());
        _userRepo.save(newUser);

        return newUser.getSecret().toString();
    }
}
