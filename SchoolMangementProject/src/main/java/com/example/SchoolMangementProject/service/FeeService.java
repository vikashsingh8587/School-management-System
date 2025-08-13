package com.example.SchoolMangementProject.service;


import com.example.SchoolMangementProject.entity.Fee;
import com.example.SchoolMangementProject.repo.FeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FeeService {

    private final FeeRepository feeRepository;

    // Create Fee
    public Fee createFee(Fee fee) {
        if (fee.getPaid() && fee.getPaidAt() == null) {
            fee.setPaidAt(LocalDate.now());

        }
        return feeRepository.save(fee);
    }

    // Get all Fees
    public List<Fee> getAllFees() {
        return feeRepository.findAll();
    }

    // Get Fee by ID
    public Fee getFeeById(String id) {
        return feeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Fee not found with ID: " + id));
    }

    // Update Fee
    public Fee updateFee(String id, Fee updatedFee) {
        Fee existingFee = getFeeById(id);

        existingFee.setStudentId(updatedFee.getStudentId());
        existingFee.setAmount(updatedFee.getAmount());
        existingFee.setDueDate(updatedFee.getDueDate());
        existingFee.setPaid(updatedFee.getPaid());
        existingFee.setPaidAt(updatedFee.getPaidAt());
        existingFee.setPaymentReference(updatedFee.getPaymentReference());

        return feeRepository.save(existingFee);
    }

    // Delete Fee
    public void deleteFee(String id) {
        if (!feeRepository.existsById(id)) {
            throw new RuntimeException("Fee not found with ID: " + id);
        }
        feeRepository.deleteById(id);
    }

    // Mark Fee as Paid
    public Fee markFeeAsPaid(String id, String paymentReference) {
        Fee fee = getFeeById(id);
        fee.setPaid(true);
        fee.setPaidAt(LocalDate.now());
        fee.setPaymentReference(paymentReference);
        return feeRepository.save(fee);
    }

    // Get Fees by Student ID
    public List<Fee> getFeesByStudentId(String studentId) {
        return feeRepository.findByStudentId(studentId);
    }
}

