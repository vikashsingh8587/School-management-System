package com.example.SchoolMangementProject.service;

import com.example.SchoolMangementProject.entity.Teacher;
import com.example.SchoolMangementProject.repo.TeacherRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class TeacherServices {
    private final TeacherRepo teacherRepository;

    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    public Teacher getTeacherById(String id) {
        return teacherRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Teacher not found"));
    }

    public Teacher createTeacher(Teacher teacher) {
        if (teacherRepository.findByEmail(teacher.getEmail()).isPresent()) {
            throw new RuntimeException("Email already exists");
        }
        return teacherRepository.save(teacher);
    }

    public Teacher updateTeacher(String id, Teacher updatedTeacher) {
        Teacher existing = getTeacherById(id);
        existing.setFirstName(updatedTeacher.getFirstName());
        existing.setLastName(updatedTeacher.getLastName());
        existing.setEmail(updatedTeacher.getEmail());
        existing.setPhone(updatedTeacher.getPhone());
        existing.setDob(updatedTeacher.getDob());
        existing.setAddress(updatedTeacher.getAddress());
        existing.setQualification(updatedTeacher.getQualification());
        existing.setExperienceYears(updatedTeacher.getExperienceYears());
        existing.setSubjectIds(updatedTeacher.getSubjectIds());
        existing.setClassIds(updatedTeacher.getClassIds());
        existing.setProfileImage(updatedTeacher.getProfileImage());
        return teacherRepository.save(existing);
    }

    public void deleteTeacher(String id) {
        teacherRepository.deleteById(id);
    }
}
