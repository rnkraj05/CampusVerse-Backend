package com.campusverse.service;

import com.campusverse.dto.ContactDTO;
import com.campusverse.response.ApiResponse;

public interface ContactService {

    ApiResponse saveContact(ContactDTO contactDTO);

    ApiResponse getAllContacts();

}