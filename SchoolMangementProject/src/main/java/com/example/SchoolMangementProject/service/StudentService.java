package com.example.SchoolMangementProject.service;

import com.example.SchoolMangementProject.entity.Photo;
import com.example.SchoolMangementProject.entity.Student;
import com.example.SchoolMangementProject.repo.StudentRepo;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;
@Data
@Service
@RequiredArgsConstructor
public class StudentService {
    @Autowired
    private StudentRepo studentRepo;
    @Autowired
    private  SequenceGenerator sequenceGenerator;
    @Autowired
    private  PhotoService photoService;

    // Create Student
    public Student createStudent(Student student, MultipartFile profileImage)throws Exception {
        long seq=sequenceGenerator.generateSequence("student_Sequence");
        String stuId=String.format("ST%03d",seq);
        Photo photo= photoService.savePhoto(profileImage);
        student.setProfileImage(photo);
        student.setId(stuId);


        return studentRepo.save(student);
    }

    // Get All Students
    public List<Student> getAllStudents() {
        return studentRepo.findAll();
    }

    // Get Student by ID
    public Optional<Student> getStudentById(String id) {
        return studentRepo.findById(id);
    }

    // Update Student
    public Student updateStudent(String id, Student updatedStudent) {
        return studentRepo.findById(id)
                .map(student -> {
                    student.setRollNo(updatedStudent.getRollNo());
                    student.setFirstName(updatedStudent.getFirstName());
                    student.setLastName(updatedStudent.getLastName());
                    student.setEmail(updatedStudent.getEmail());
                    student.setPhone(updatedStudent.getPhone());
                    student.setAddress(updatedStudent.getAddress());
                    student.setClazz(updatedStudent.getClazz());
                    student.setSection(updatedStudent.getSection());
                    student.setDob(updatedStudent.getDob());
                    student.setProfileImage(updatedStudent.getProfileImage());
                    student.setEnrolledSubjects(updatedStudent.getEnrolledSubjects());
                    return studentRepo.save(student);
                }).orElseThrow(() -> new RuntimeException("Student not found with id: " + id));
    }

    // Delete Student
    public void deleteStudent(String id) {
        if (!studentRepo.existsById(id)) {
            throw new RuntimeException("Student not found with id: " + id);
        }
        studentRepo.deleteById(id);
    }

    // Search by name
    public List<Student> searchStudentsByName(String name) {
        return studentRepo.findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(name, name);
    }

    // Search by class
    public List<Student> getStudentsByClass(String clazz) {
        return studentRepo.findByClazz(clazz);
    }
}

