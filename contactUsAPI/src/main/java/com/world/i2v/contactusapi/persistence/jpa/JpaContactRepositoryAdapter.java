package com.world.i2v.contactusapi.persistence.jpa;


import com.world.i2v.contactusapi.model.ContactRecord;
import com.world.i2v.contactusapi.persistence.jpa.entity.ContactEntity;
import com.world.i2v.contactusapi.persistence.port.ContactRepositoryPort;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

@Repository
@Profile("jpa")
public class JpaContactRepositoryAdapter implements ContactRepositoryPort {

    private final SpringDataContactJpaRepository repo;

    public JpaContactRepositoryAdapter(SpringDataContactJpaRepository repo) {
        this.repo = repo;
    }

    @Override
    public ContactRecord save(ContactRecord record) {

        // Convert domain model → JPA entity
        ContactEntity entity = new ContactEntity();
        entity.setName(record.getName());
        entity.setEmail(record.getEmail());
        entity.setMessage(record.getMessage());
        entity.setLat(record.getLat());
        entity.setLng(record.getLng());
        entity.setCreatedAt(record.getCreatedAt());
        entity.setSource(record.getSource());
        entity.setIpAddress(record.getIpAddress());

        // Save to SQL DB
        ContactEntity saved = repo.save(entity);

        // Convert back JPA entity → domain model
        ContactRecord result = new ContactRecord();
        result.setId(String.valueOf(saved.getId()));
        result.setName(saved.getName());
        result.setEmail(saved.getEmail());
        result.setMessage(saved.getMessage());
        result.setLat(saved.getLat());
        result.setLng(saved.getLng());
        result.setCreatedAt(saved.getCreatedAt());
        result.setSource(saved.getSource());
        result.setIpAddress(saved.getIpAddress());

        return result;
    }
}
