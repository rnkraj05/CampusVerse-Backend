package com.campusverse.service;

import com.campusverse.dto.JourneyDTO;
import com.campusverse.response.ApiResponse;

public interface JourneyService {

    ApiResponse saveJourney(JourneyDTO journeyDTO);

    ApiResponse getAllJourneys();

}