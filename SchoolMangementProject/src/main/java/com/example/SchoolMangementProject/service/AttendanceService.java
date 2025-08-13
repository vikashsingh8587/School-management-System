package com.example.SchoolMangementProject.service;



import com.example.SchoolMangementProject.entity.Attendance;
import com.example.SchoolMangementProject.repo.AttendenceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AttendanceService {

    private final AttendenceRepository attendanceRepository;

    // Create Attendance
    public Attendance createAttendance(Attendance attendance) {
        return attendanceRepository.save(attendance);
    }

    // Get All Attendances
    public List<Attendance> getAllAttendances() {
        return attendanceRepository.findAll();
    }

    // Get Attendance by ID
    public Attendance getAttendanceById(String id) {
        return attendanceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Attendance not found with ID: " + id));
    }

    // Get Attendance by Student ID
    public List<Attendance> getAttendanceByStudentId(String studentId) {
        return attendanceRepository.findByStudentId(studentId);
    }

    // Get Attendance by Date
    public List<Attendance> getAttendanceByDate(LocalDate date) {
        return attendanceRepository.findByDate(date);
    }

    // Update Attendance
    public Attendance updateAttendance(String id, Attendance updatedAttendance) {
        Attendance existing = getAttendanceById(id);

        existing.setStudentId(updatedAttendance.getStudentId());
        existing.setDate(updatedAttendance.getDate());
        existing.setPresent(updatedAttendance.isPresent());
        existing.setRemark(updatedAttendance.getRemark());

        return attendanceRepository.save(existing);
    }

    // Delete Attendance
    public void deleteAttendance(String id) {
        if (!attendanceRepository.existsById(id)) {
            throw new RuntimeException("Attendance not found with ID: " + id);
        }
        attendanceRepository.deleteById(id);
    }
}

