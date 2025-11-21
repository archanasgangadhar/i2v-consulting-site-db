package com.world.i2v.contactusapi.persistence.port;


import com.world.i2v.contactusapi.model.ContactRecord;

public interface ContactRepositoryPort {

    ContactRecord save(ContactRecord record);

}
