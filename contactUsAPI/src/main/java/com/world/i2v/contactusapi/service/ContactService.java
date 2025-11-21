package com.world.i2v.contactusapi.service;


import com.world.i2v.contactusapi.dto.ContactRequest;
import com.world.i2v.contactusapi.ipgeo.IpGeoService;
import com.world.i2v.contactusapi.mail.EmailService;
import com.world.i2v.contactusapi.model.ContactRecord;
import com.world.i2v.contactusapi.persistence.port.ContactRepositoryPort;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class ContactService {

    private final ContactRepositoryPort repository;
    private final EmailService emailService;
    private final IpGeoService ipGeoService;

    public ContactService(ContactRepositoryPort repository,
                          EmailService emailService,
                          IpGeoService ipGeoService) {
        this.repository = repository;
        this.emailService = emailService;
        this.ipGeoService = ipGeoService;
    }

    public ContactRecord processSubmission(ContactRequest request, String clientIp) {

        ContactRecord record = new ContactRecord();

        // Basic fields
        record.setName(request.getName());
        record.setEmail(request.getEmail());
        record.setMessage(request.getMessage());
        record.setCreatedAt(Instant.now());
        record.setIpAddress(clientIp);

        // ---------------------------------------------
        // 1. Browser location available?
        // ---------------------------------------------
        if (request.getLat() != null && request.getLng() != null) {
            record.setLat(request.getLat());
            record.setLng(request.getLng());
            record.setSource("browser");
        } else {
            // ---------------------------------------------
            // 2. Otherwise fallback: approximate IP geolocation
            // ---------------------------------------------
            ipGeoService.lookup(clientIp).ifPresent(loc -> {
                record.setLat(loc.lat);
                record.setLng(loc.lng);
            });
            record.setSource("ip");
        }

        // ---------------------------------------------
        // Save to database through db-independent port
        // ---------------------------------------------
        ContactRecord saved = repository.save(record);

        // ---------------------------------------------
        // Send email to HR asynchronously
        // ---------------------------------------------
        emailService.sendContactNotification(saved);

        return saved;
    }
}
