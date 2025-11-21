package com.world.i2v.contactusapi.controller;


import com.world.i2v.contactusapi.dto.ContactRequest;
import com.world.i2v.contactusapi.model.ContactRecord;
import com.world.i2v.contactusapi.service.ContactService;
import com.world.i2v.contactusapi.util.IpUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/contact")
public class ContactController {

    private final ContactService service;

    public ContactController(ContactService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<?> submit(
            @Valid @RequestBody ContactRequest request,
            HttpServletRequest httpRequest
    ) {

        // Extract client IP (even behind proxy)
        String clientIp = IpUtil.getClientIp(httpRequest);

        // Process and save
        ContactRecord saved = service.processSubmission(request, clientIp);

        // Return response
        return ResponseEntity.ok(Map.of(
                "id", saved.getId(),
                "status", "success"
        ));
    }
}
