package com.jpa.example.jpa_example.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import javax.persistence.*;

@Table
@Getter
@Setter
@Entity
public class Authorize {
    @Id
    private String authId;

    @Column(unique = true)
    private String authName;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user;

}
