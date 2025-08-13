package com.example.SchoolMangementProject.service;

import com.example.SchoolMangementProject.entity.Homework;
import com.example.SchoolMangementProject.repo.ClassRepo;
import com.example.SchoolMangementProject.repo.HomeWorkRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class HomeWorkService {
    @Autowired
    private final HomeWorkRepository homeworkRepository;
    @Autowired
    private ClassRepo classRepo;

    public List<Homework> getHomeworksForClass(String className) {
        return homeworkRepository.findByClassName(className);
    }

    public Homework createHomework(Homework hw) {
        hw.setAssignedAt(LocalDateTime.now());
        hw.setStatus("PENDING");
        return homeworkRepository.save(hw);
    }

    public Homework submitHomework(String homeworkId, String studentId, String submissionFileUrl) {
        Homework hw = homeworkRepository.findById(homeworkId)
                .orElseThrow(() -> new RuntimeException("Homework not found"));
        hw.setSubmittedByStudentId(studentId);
        hw.setSubmissionFileUrl(submissionFileUrl);
        hw.setSubmittedAt(LocalDateTime.now());
        hw.setStatus("SUBMITTED");
        return homeworkRepository.save(hw);
    }
}

