package com.world.i2v.contactusapi.persistence.jpa.entity;



import jakarta.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "contacts")
public class ContactEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column(length = 2000)
    private String message;

    private Double lat;
    private Double lng;

    private Instant createdAt;

    private String source;      // "browser" or "ip"
    private String ipAddress;

    // ---------------- Constructors ----------------

    public ContactEntity() {}

    // ---------------- Getters & Setters ----------------

    public Long getId() {
        return id;
    }

    public void setId(Long id) { this.id = id; }

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

    public String getSource() { return source; }

    public void setSource(String source) { this.source = source; }

    public String getIpAddress() { return ipAddress; }

    public void setIpAddress(String ipAddress) { this.ipAddress = ipAddress; }
}
