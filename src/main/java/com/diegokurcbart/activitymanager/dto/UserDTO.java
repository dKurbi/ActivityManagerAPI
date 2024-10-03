package com.diegokurcbart.activitymanager.dto;

import com.diegokurcbart.activitymanager.model.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    private Long userId;

    @NotBlank(message = "Name is mandatory")
    @Size(max = 50, message = "Name must be between 1 and 50 characters")
    private String name;

    @NotBlank(message = "Surname is mandatory")
    @Size(min = 1, max = 50, message = "Surname must be between 1 and 50 characters")
    private String surname;

    @NotNull(message = "Birthdate is mandatory")
    @Past(message = "Birthdate must be a date in the past")
    private LocalDate birthDate;

    @NotBlank(message = "Email is mandatory")
    @Email(message = "Email should be valid")
    @Size(max = 100)
    private String email;

    //Constructors
    public UserDTO(User user) {
        this.setUserId(user.getUserId());
        this.setName(user.getName());
        this.setSurname(user.getSurname());
        this.setBirthDate(user.getBirthDate());
        this.setEmail(user.getEmail());
    }
}
