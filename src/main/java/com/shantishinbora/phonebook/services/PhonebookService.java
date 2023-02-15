package com.shantishinbora.phonebook.services;

import com.shantishinbora.phonebook.entities.Phonebook;
import com.shantishinbora.phonebook.repositories.PhonebookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class PhonebookService {
    @Autowired
    PhonebookRepository phonebookRepository;

    public List<Phonebook> getAllPhonebook(){
        return phonebookRepository.findAll();
    }

    public Phonebook addPhonebook(Phonebook phonebook){
        Optional<Phonebook> checkRegisteredEmail = phonebookRepository.findPhonebookByEmail(phonebook.getEmail());
        if(checkRegisteredEmail.isPresent()){
            throw new IllegalStateException("Email is already registered");
        }
        return phonebookRepository.save(phonebook);
    }

    private void checkIfPhonebookExist(Optional<Phonebook> phonebook){
        if(phonebook.isEmpty()){
            throw new IllegalStateException("Phonebook id " + phonebook.get().getId() + " doesn't exists");
        }
    }
    public Optional<Phonebook> getPhonebookById(Long id){
        Optional<Phonebook> phonebookExist = phonebookRepository.findById(id);
        checkIfPhonebookExist(phonebookExist);
        return phonebookExist;
    }

    public void updatePhonebook(Long id, String name, String email, String phone, String address){
        Optional<Phonebook> phonebookExist = phonebookRepository.findById(id);
        checkIfPhonebookExist(phonebookExist);
        if (name != null && name.length() > 0 && !Objects.equals(phonebookExist.get().getName(), name)) {
            phonebookExist.get().setName(name);
        }
        if (email != null && email.length() > 0 && !Objects.equals(phonebookExist.get().getEmail(), email)) {
            phonebookExist.get().setEmail(email);
        }
        if (phone != null && phone.length() > 0 && !Objects.equals(phonebookExist.get().getPhone(), phone)) {
            phonebookExist.get().setPhone(phone);
        }
        if (address != null && address.length() > 0 && !Objects.equals(phonebookExist.get().getAddress(), address)) {
            phonebookExist.get().setAddress(address);
        }
        phonebookRepository.save(phonebookExist.get());
    }

    @Transactional
    public void deletePhonebook(Long id){
        phonebookRepository.deleteById(id);
    }
}
