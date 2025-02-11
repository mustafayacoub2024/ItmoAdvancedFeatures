package com.example.ItmoAdvancedFeatures.extended.model.db.repository;

import com.example.ItmoAdvancedFeatures.extended.model.db.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User getUserByAgeAndEmailAndStatus(String email, String firstName);
}
