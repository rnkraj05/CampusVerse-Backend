package com.campusverse.controller;

import com.campusverse.dto.ContactDTO;
import com.campusverse.response.ApiResponse;
import com.campusverse.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/contact")
@CrossOrigin("*")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @PostMapping
    public ApiResponse saveContact(@RequestBody ContactDTO contactDTO) {

        return contactService.saveContact(contactDTO);
    }

    @GetMapping
    public ApiResponse getAllContacts() {

        return contactService.getAllContacts();
    }
}