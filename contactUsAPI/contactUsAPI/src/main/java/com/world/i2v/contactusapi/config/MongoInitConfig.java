package com.world.i2v.contactusapi.config;



import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
@Profile("mongo")
public class MongoInitConfig {

    @Bean
    public ApplicationRunner mongoInitializer(MongoTemplate mongoTemplate) {
        return args -> {
            String coll = "contacts";
            if (!mongoTemplate.collectionExists(coll)) {
                mongoTemplate.createCollection(coll);
                System.out.println("Created collection: " + coll);
            }


        };
    }
}
