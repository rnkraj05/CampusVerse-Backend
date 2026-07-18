package com.campusverse.service;

import com.campusverse.dto.ResourceDTO;
import com.campusverse.response.ApiResponse;

public interface ResourceService {

    ApiResponse saveResource(ResourceDTO dto);

    ApiResponse getAllResources();

}