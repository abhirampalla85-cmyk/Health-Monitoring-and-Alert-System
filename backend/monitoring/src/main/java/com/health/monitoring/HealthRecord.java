package com.health.monitoring;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class HealthRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double temperature;
    private int heartRate;
    private double sleepHours;
    private int fatigueLevel;   // ✅ CORRECT FIELD

    private String status;
    private Long userId;

    public HealthRecord() {}

    public Long getId() {
        return id;
    }

    // ✅ TEMPERATURE
    public double getTemperature() {
        return temperature;
    }
    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    // ✅ HEART RATE
    public int getHeartRate() {
        return heartRate;
    }
    public void setHeartRate(int heartRate) {
        this.heartRate = heartRate;
    }

    // ✅ SLEEP
    public double getSleepHours() {
        return sleepHours;
    }
    public void setSleepHours(double sleepHours) {
        this.sleepHours = sleepHours;
    }

    // 🔥 FIXED (VERY IMPORTANT)
    public int getFatigueLevel() {
        return fatigueLevel;
    }
    public void setFatigueLevel(int fatigueLevel) {
        this.fatigueLevel = fatigueLevel;
    }

    // ✅ STATUS
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    // ✅ USER ID
    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }
}