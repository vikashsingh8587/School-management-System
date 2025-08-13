package com.example.SchoolMangementProject.service;

import com.example.SchoolMangementProject.entity.Subject;
import com.example.SchoolMangementProject.repo.SubjectRepo;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
@Data
@AllArgsConstructor
public class SubjectService {

    @Autowired
    private final SubjectRepo subjectRepository;

    public List<Subject> getAllSubjects() {
        return subjectRepository.findAll();
    }

    public Subject getSubjectById(String id) {
        return subjectRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Subject not found"));
    }

    public Subject createSubject(Subject subject) {
        // Check if code already exists
        if (subjectRepository.findByCode(subject.getCode()).isPresent()) {
            throw new RuntimeException("Subject code already exists");
        }
        return subjectRepository.save(subject);
    }

    public Subject updateSubject(String id, Subject updatedSubject) {
        Subject existing = getSubjectById(id);
        existing.setName(updatedSubject.getName());
        existing.setCode(updatedSubject.getCode());
        existing.setDescription(updatedSubject.getDescription());
        existing.setTeacherId(updatedSubject.getTeacherId());
        return subjectRepository.save(existing);
    }
    public void deleteSubject(String id) {
        subjectRepository.deleteById(id);
    }
}
