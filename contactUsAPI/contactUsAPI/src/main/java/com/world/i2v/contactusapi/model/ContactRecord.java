package com.world.i2v.contactusapi.model;



import java.time.Instant;

public class ContactRecord {

    private String id;
    private String name;
    private String email;
    private String message;
    private Double lat;
    private Double lng;
    private Instant createdAt;
    private String source;      // "browser" or "ip"
    private String ipAddress;   // captured from request

    public ContactRecord() {}

    public ContactRecord(String id, String name, String email, String message, Double lat, Double lng,
                         Instant createdAt, String source, String ipAddress) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.message = message;
        this.lat = lat;
        this.lng = lng;
        this.createdAt = createdAt;
        this.source = source;
        this.ipAddress = ipAddress;
    }

    // ----------- Getters & Setters ------------

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }
}
