package com.world.i2v.contactusapi.mongo;



import com.world.i2v.contactusapi.mongo.document.ContactDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringDataContactMongoRepository extends MongoRepository<ContactDocument, String> {
}
