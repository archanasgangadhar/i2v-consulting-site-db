package com.world.i2v.contactusapi.mongo;



import com.world.i2v.contactusapi.model.ContactRecord;
import com.world.i2v.contactusapi.mongo.document.ContactDocument;
import com.world.i2v.contactusapi.persistence.port.ContactRepositoryPort;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

@Repository
@Profile("mongo")
public class MongoContactRepositoryAdapter implements ContactRepositoryPort {

    private final SpringDataContactMongoRepository repo;

    public MongoContactRepositoryAdapter(SpringDataContactMongoRepository repo) {
        this.repo = repo;
    }

    @Override
    public ContactRecord save(ContactRecord record) {

        // Map domain → Mongo document
        ContactDocument doc = new ContactDocument();
        doc.setName(record.getName());
        doc.setEmail(record.getEmail());
        doc.setMessage(record.getMessage());
        doc.setLat(record.getLat());
        doc.setLng(record.getLng());
        doc.setCreatedAt(record.getCreatedAt());
        doc.setSource(record.getSource());
        doc.setIpAddress(record.getIpAddress());

        // Save in Mongo
        ContactDocument saved = repo.save(doc);

        // Return domain model
        ContactRecord result = new ContactRecord();
        result.setId(saved.getId());
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
