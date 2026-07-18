package com.campusverse.controller;

import com.campusverse.dto.ResourceDTO;
import com.campusverse.response.ApiResponse;
import com.campusverse.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/resources")
@CrossOrigin("*")
public class ResourceController {

    @Autowired
    private ResourceService resourceService;

    @PostMapping
    public ApiResponse saveResource(@RequestBody ResourceDTO dto){

        return resourceService.saveResource(dto);

    }

    @GetMapping
    public ApiResponse getAllResources(){

        return resourceService.getAllResources();

    }

}