package com.shantishinbora.phonebook.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;

@Entity
@Table(name="phonebook")
@Getter
@Setter
public class Phonebook {
    @Id
    @SequenceGenerator(
            name = "phonebook_sequence",
            sequenceName = "phonebook_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "phonebook_sequence"
    )

    private Long id;
    private String name;
    private String email;
    private String phone;
    private String address;

    public Phonebook() {
    }

    public Phonebook(Long id, String name, String email, String phone, String address) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    public Phonebook(String name, String email, String phone, String address) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

}
