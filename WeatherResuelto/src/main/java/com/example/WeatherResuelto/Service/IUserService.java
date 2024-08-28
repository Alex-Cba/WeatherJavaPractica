package com.example.WeatherResuelto.Service;

import com.example.WeatherResuelto.Common.Request.BasicLogin;
import com.example.WeatherResuelto.Common.Request.UserRegister;

public interface IUserService {

    String BasicLogin(BasicLogin login);

    String UserRegister(UserRegister register);
}
