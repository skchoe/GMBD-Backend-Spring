package com.ctd.gmbd.simple.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthRepository extends JpaRepository<AuthUserEntity, Long> {
    // Basic CRUD operations like save() are included by default
}