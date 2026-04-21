package com.health.monitoring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/api/health")
public class HealthController {

    @Autowired
    private HealthRepository repo;

    @PostMapping("/save")
    public String save(@RequestBody HealthRecord record){

        String status = "Normal";

        double temp = record.getTemperature();
        int heart = record.getHeartRate();
        double sleep = record.getSleepHours();
        int fatigue = record.getFatigueLevel();

        // ✅ CORRECT LOGIC (exactly what you asked)

        if(
            temp > 98 ||                 // >98 abnormal
            heart < 60 || heart > 100 || // outside 60-100 abnormal
            sleep < 6 ||                 // <6 abnormal
            fatigue > 3                  // >3 abnormal
        ){
            status = "Abnormal";
        }

        record.setStatus(status);

        // ✅ SAVE ALWAYS
        repo.save(record);

        return status;
    }

    @GetMapping("/history/{userId}")
    public List<HealthRecord> history(@PathVariable Long userId){
        return repo.findByUserId(userId);
    }
}