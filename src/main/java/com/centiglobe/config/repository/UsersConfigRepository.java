package com.centiglobe.config.repository;

import com.centiglobe.config.entity.UsersConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersConfigRepository extends JpaRepository<UsersConfig, Long> {

}
