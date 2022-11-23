package com.assessment.testschool.repository;

import com.assessment.testschool.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    Optional<Object> findByUserName(String userName);

    List<User> findByTag(String student);
}
