package com.campusverse.serviceimpl;

import com.campusverse.dto.ResourceDTO;
import com.campusverse.entity.Resource;
import com.campusverse.repository.ResourceRepository;
import com.campusverse.response.ApiResponse;
import com.campusverse.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ResourceServiceImpl implements ResourceService {

    @Autowired
    private ResourceRepository resourceRepository;

    @Override
    public ApiResponse saveResource(ResourceDTO dto) {

        Resource resource = Resource.builder()
                .title(dto.getTitle())
                .category(dto.getCategory())
                .type(dto.getType())
                .description(dto.getDescription())
                .resourceLink(dto.getResourceLink())
                .createdAt(LocalDateTime.now())
                .build();

        resourceRepository.save(resource);

        return new ApiResponse(
                true,
                "Resource Added Successfully",
                resource
        );
    }

    @Override
    public ApiResponse getAllResources() {

        return new ApiResponse(
                true,
                "Resources List",
                resourceRepository.findAll()
        );
    }
}