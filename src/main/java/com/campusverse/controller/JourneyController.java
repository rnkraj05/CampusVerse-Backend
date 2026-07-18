package com.campusverse.controller;

import com.campusverse.dto.JourneyDTO;
import com.campusverse.response.ApiResponse;
import com.campusverse.service.JourneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/journeys")
@CrossOrigin("*")
public class JourneyController {

    @Autowired
    private JourneyService journeyService;

    @PostMapping
    public ApiResponse saveJourney(@RequestBody JourneyDTO journeyDTO){

        return journeyService.saveJourney(journeyDTO);

    }

    @GetMapping
    public ApiResponse getAllJourneys(){

        return journeyService.getAllJourneys();

    }

}