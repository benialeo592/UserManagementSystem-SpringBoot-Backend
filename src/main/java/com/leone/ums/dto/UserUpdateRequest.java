package com.leone.ums.dto;

import com.leone.ums.entity.Company;
import com.leone.ums.entity.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserUpdateRequest {

    private String firstname;
    private String lastname;
    @Column(unique = true)
    private String email;
    private Company company;
    private Role role;
}
