package com.world.i2v.contactusapi.mongo.document;



import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Document(collection = "contacts")
public class ContactDocument {

    @Id
    private String id;

    private String name;
    private String email;
    private String message;

    private Double lat;
    private Double lng;

    private Instant createdAt;
    private String source;
    private String ipAddress;

    // ---------------- Constructors ----------------

    public ContactDocument() {}

    // ---------------- Getters & Setters ----------------

    public String getId() {
        return id;
    }

    public void setId(String id) { this.id = id; }

    public String getName() {
        return name;
    }

    public void setName(String name) { this.name = name; }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) { this.email = email; }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) { this.message = message; }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) { this.lat = lat; }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) { this.lng = lng; }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) { this.createdAt = createdAt; }

    public String getSource() {
        return source;
    }

    public void setSource(String source) { this.source = source; }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) { this.ipAddress = ipAddress; }
}
