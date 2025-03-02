package com.example.taskexpensemanager.controller;

import com.example.taskexpensemanager.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/dashboard")
public class DashboardController {

    @Autowired
    private DashboardService dashboardService;

    @GetMapping("/{userId}")
    public ResponseEntity<Map<String, Object>> getDashboardData(@PathVariable Long userId) {
        return ResponseEntity.ok(dashboardService.getDashboardData(userId));
    }
}
