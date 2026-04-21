package com.health.monitoring;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface HealthRepository extends JpaRepository<HealthRecord, Long> {

    List<HealthRecord> findByUserId(Long userId);

}