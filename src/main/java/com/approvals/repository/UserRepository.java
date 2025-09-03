package com.approvals.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.approvals.model.WebUser;
import java.util.Optional;

public interface UserRepository extends JpaRepository<WebUser, Long> {
    Optional<WebUser> findByUsername(String username);
}