package com.campusverse.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "journeys")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Journey {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(length = 2000)
    private String description;

    private String status;

    private LocalDateTime createdAt;

}