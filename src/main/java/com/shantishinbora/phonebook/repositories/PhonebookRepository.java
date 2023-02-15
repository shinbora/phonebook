package com.shantishinbora.phonebook.repositories;

import com.shantishinbora.phonebook.entities.Phonebook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PhonebookRepository extends JpaRepository<Phonebook, Long> {
    Optional<Phonebook> findPhonebookByEmail(String email);
}
