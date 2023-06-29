package com.crud.operation.springbootbackend.entity;

import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="employees")
public class Employee {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    @Column(name="first_name", nullable=false)
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="email", unique = true)
    private String email;

    public Employee(String firstName, String lastName, String email) {
        this.firstName=firstName;
        this.lastName=lastName;
        this.email=email;
    }
}