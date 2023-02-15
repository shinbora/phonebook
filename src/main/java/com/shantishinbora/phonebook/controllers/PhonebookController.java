package com.shantishinbora.phonebook.controllers;

import com.shantishinbora.phonebook.dto.response.GetAllPhonebookResponse;
import com.shantishinbora.phonebook.entities.Phonebook;
import com.shantishinbora.phonebook.services.PhonebookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/phonebook")
public class PhonebookController {
    @Autowired
    PhonebookService phonebookService;

    @GetMapping
    public ResponseEntity<GetAllPhonebookResponse> getAllPhonebook(){
        List phonebook = phonebookService.getAllPhonebook();
        GetAllPhonebookResponse response = new GetAllPhonebookResponse();
        response.setPhonebookList(phonebook);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Phonebook> getPhonebookById(@PathVariable Long id){
        Optional<Phonebook> phonebookCust = phonebookService.getPhonebookById(id);
        return new ResponseEntity<>(phonebookCust.get(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<HttpStatus> addPhonebook(@RequestBody Phonebook phonebook){
        phonebookService.addPhonebook(phonebook);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Phonebook> updatePhonebook(@PathVariable Long id, @RequestBody Phonebook phonebook){
        String name = phonebook.getName();
        String email = phonebook.getEmail();
        String phone = phonebook.getPhone();
        String address = phonebook.getAddress();
        phonebookService.updatePhonebook(id, name, email, phone, address);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deletePhonebook(@PathVariable Long id){
        phonebookService.deletePhonebook(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
