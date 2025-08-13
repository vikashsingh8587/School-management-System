package com.example.SchoolMangementProject.controller;



import com.example.SchoolMangementProject.entity.Fee;
import com.example.SchoolMangementProject.service.FeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fees")
@RequiredArgsConstructor
public class FeeController {

    private final FeeService feeService;

    // Create Fee
    @PostMapping
    public ResponseEntity<Fee> createFee(@RequestBody Fee fee) {
        return ResponseEntity.ok(feeService.createFee(fee));
    }

    // Get All Fees
    @GetMapping
    public ResponseEntity<List<Fee>> getAllFees() {
        return ResponseEntity.ok(feeService.getAllFees());
    }

    // Get Fee by ID
    @GetMapping("/{id}")
    public ResponseEntity<Fee> getFeeById(@PathVariable String id) {
        return ResponseEntity.ok(feeService.getFeeById(id));
    }

    // Get Fees by Student ID
    @GetMapping("/student/{studentId}")
    public ResponseEntity<List<Fee>> getFeesByStudentId(@PathVariable String studentId) {
        return ResponseEntity.ok(feeService.getFeesByStudentId(studentId));
    }

    // Update Fee
    @PutMapping("/{id}")
    public ResponseEntity<Fee> updateFee(@PathVariable String id, @RequestBody Fee fee) {
        return ResponseEntity.ok(feeService.updateFee(id, fee));
    }

    // Delete Fee
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteFee(@PathVariable String id) {
        feeService.deleteFee(id);
        return ResponseEntity.ok("Fee deleted successfully");
    }

    // Mark Fee as Paid
    @PutMapping("/{id}/mark-paid")
    public ResponseEntity<Fee> markFeeAsPaid(@PathVariable String id, @RequestParam String paymentReference) {
        return ResponseEntity.ok(feeService.markFeeAsPaid(id, paymentReference));
    }
}

