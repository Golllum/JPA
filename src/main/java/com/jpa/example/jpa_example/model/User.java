package com.jpa.example.jpa_example.model;

import lombok.*;
import javax.persistence.*;

@Entity
@Table

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    private String id;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String userName;

}
