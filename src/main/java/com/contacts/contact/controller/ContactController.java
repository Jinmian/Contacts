package com.contacts.contact.controller;

import com.contacts.contact.model.ContactModel;
import com.contacts.contact.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/contacts")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @GetMapping
    public ResponseEntity<List<ContactModel>> getAllContacts() {
        return ResponseEntity.ok(contactService.getAllContacts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContactModel> getContactById(@PathVariable Integer id) {
        Optional<ContactModel> contact = contactService.getContactById(id);
        if (!contact.isPresent()) {
            ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(contact.get());
    }

    @PostMapping("/add")
    public ContactModel createContact(@RequestBody ContactModel contactModel) {
        return contactService.save(contactModel);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ContactModel> update(@PathVariable Integer id,@RequestBody ContactModel contactModel) {
        if (!contactService.getContactById(id).isPresent()) {
            ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(contactService.save(contactModel));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteContactById(@PathVariable Integer id) {
        if (!contactService.getContactById(id).isPresent()) {
            ResponseEntity.badRequest().build();
        }
        contactService.deleteContactById(id);

        return ResponseEntity.ok().build();
    }
}

