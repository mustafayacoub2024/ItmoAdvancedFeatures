package com.example.ItmoAdvancedFeatures.extended.model.db.repository;

import com.example.ItmoAdvancedFeatures.extended.model.db.entity.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User getUserByEmailAndFirstName(String email, String firstName);

    @Query("select c from Car c where c.brand like %:filter% or c.model like %:filter% " )
    List<User> findAllFiltered(Pageable pageRequest, @Param("filter") String filter);
}
