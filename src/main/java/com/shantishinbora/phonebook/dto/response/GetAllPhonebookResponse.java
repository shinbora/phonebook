package com.shantishinbora.phonebook.dto.response;

import com.shantishinbora.phonebook.entities.Phonebook;
import lombok.Data;

import java.util.List;

@Data
public class GetAllPhonebookResponse {
    List<Phonebook> phonebookList;
}
