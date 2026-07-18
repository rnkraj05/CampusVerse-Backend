package com.campusverse.serviceimpl;

import com.campusverse.dto.JourneyDTO;
import com.campusverse.entity.Journey;
import com.campusverse.repository.JourneyRepository;
import com.campusverse.response.ApiResponse;
import com.campusverse.service.JourneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class JourneyServiceImpl implements JourneyService {

    @Autowired
    private JourneyRepository journeyRepository;

    @Override
    public ApiResponse saveJourney(JourneyDTO journeyDTO) {

        Journey journey = Journey.builder()
                .title(journeyDTO.getTitle())
                .description(journeyDTO.getDescription())
                .status(journeyDTO.getStatus())
                .createdAt(LocalDateTime.now())
                .build();

        journeyRepository.save(journey);

        return new ApiResponse(
                true,
                "Journey Saved Successfully",
                journey
        );
    }

    @Override
    public ApiResponse getAllJourneys() {

        return new ApiResponse(
                true,
                "Journey List",
                journeyRepository.findAll()
        );
    }
}