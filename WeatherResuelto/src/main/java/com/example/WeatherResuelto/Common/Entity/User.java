package com.example.WeatherResuelto.Common.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "Users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @Column(columnDefinition = "VARCHAR(36)")
    private String Id;

    private String Email;

    private String Password;

    private char FavTemperature;

    @PrePersist
    public void prePersist() {
        if (this.Id == null) {
            this.Id = UUID.randomUUID().toString();
        }
    }
}
