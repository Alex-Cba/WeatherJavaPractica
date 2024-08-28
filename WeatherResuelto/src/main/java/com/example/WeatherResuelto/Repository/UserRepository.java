package com.example.WeatherResuelto.Repository;

import com.example.WeatherResuelto.Common.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u WHERE u.Email = :email AND u.Password = :password")
    List<User> CheckLogin(@Param("email") String email, @Param("password") String password);

    @Query("SELECT u FROM User u WHERE u.Email = :email")
    User findbyEmail(@Param("email") String email);
}
