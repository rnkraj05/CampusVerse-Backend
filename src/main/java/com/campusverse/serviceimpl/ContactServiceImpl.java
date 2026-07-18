package com.campusverse.serviceimpl;

import com.campusverse.dto.ContactDTO;
import com.campusverse.entity.Contact;
import com.campusverse.repository.ContactRepository;
import com.campusverse.response.ApiResponse;
import com.campusverse.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactRepository contactRepository;

    @Override
    public ApiResponse saveContact(ContactDTO contactDTO) {

        Contact contact = Contact.builder()
                .name(contactDTO.getName())
                .email(contactDTO.getEmail())
                .subject(contactDTO.getSubject())
                .message(contactDTO.getMessage())
                .createdAt(LocalDateTime.now())
                .build();

        contactRepository.save(contact);

        return new ApiResponse(
                true,
                "Message Sent Successfully",
                contact
        );
    }

    @Override
    public ApiResponse getAllContacts() {

        return new ApiResponse(
                true,
                "Contact List",
                contactRepository.findAll()
        );
    }
}