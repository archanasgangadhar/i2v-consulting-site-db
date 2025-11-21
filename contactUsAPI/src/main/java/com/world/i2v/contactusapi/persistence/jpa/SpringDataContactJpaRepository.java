package com.world.i2v.contactusapi.persistence.jpa;




import com.world.i2v.contactusapi.persistence.jpa.entity.ContactEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringDataContactJpaRepository extends JpaRepository<ContactEntity, Long> {
}
