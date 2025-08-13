package com.example.SchoolMangementProject.service;

import com.example.SchoolMangementProject.entity.ClassEntity;

import com.example.SchoolMangementProject.repo.ClassRepo;
import com.example.SchoolMangementProject.repo.ClassRepoClass;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor

    public class ClassService {
        private final ClassRepo classRepository;

        public List<ClassEntity> getAllClasses() {
            return classRepository.findAll();
        }

        public ClassEntity getClassById(String id) {
            return classRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Class not found"));
        }

        public ClassEntity createClass(ClassEntity cls) {
            // You can add validation here before saving
            return classRepository.save(cls);
        }

    public ClassEntity updateClass(String id, ClassEntity updatedClass) {
        ClassEntity existing = getClassById(id);
        existing.setClassName(updatedClass.getClassName());
        existing.setSection(updatedClass.getSection());
        existing.setClassTeacherId(updatedClass.getClassTeacherId());
        existing.setSubjectIds(updatedClass.getSubjectIds());
        return classRepository.save(existing);
    }

    public void deleteClass(String id) {
        classRepository.deleteById(id);
    }

    public ClassEntity findByClassNameAndSection(String className, String section) {
        return classRepository.findByClassNameAndSection(className, section)
                .orElse(null);
    }
}



