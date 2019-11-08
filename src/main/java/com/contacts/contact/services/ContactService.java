package com.contacts.contact.services;

import com.contacts.contact.model.ContactModel;
import com.contacts.contact.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ContactService {

    @Autowired
    ContactRepository contactRepository;

    public List<ContactModel> getAllContacts(){
        return contactRepository.findAll();
    }

    public Optional<ContactModel> getContactById(Integer id){
        return contactRepository.findById(id);
    }

    public ContactModel save(ContactModel contact){
        return contactRepository.save(contact);

    }

    public void deleteContactById(Integer id){
        contactRepository.deleteById(id);
    }
}
