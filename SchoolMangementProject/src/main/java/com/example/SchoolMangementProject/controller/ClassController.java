package com.example.SchoolMangementProject.controller;

import com.example.SchoolMangementProject.entity.ClassEntity;

import com.example.SchoolMangementProject.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller

@RestController
@RequestMapping("/class")
public class ClassController {

 @Autowired
 private  ClassService classService;

    @GetMapping
    public ResponseEntity<List<ClassEntity>> getAllClasses() {
        return ResponseEntity.ok(classService.getAllClasses());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClassEntity> getClassById(@PathVariable String id) {
        return ResponseEntity.ok(classService.getClassById(id));
    }

    @PostMapping
    public ResponseEntity<ClassEntity> createClass(@RequestBody ClassEntity cls) {
        return ResponseEntity.ok(classService.createClass(cls));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClassEntity> updateClass(@PathVariable String id,
                                                   @RequestBody ClassEntity updatedClass) {
        return ResponseEntity.ok(classService.updateClass(id, updatedClass));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClass(@PathVariable String id) {
        classService.deleteClass(id);
        return ResponseEntity.noContent().build();
}
}

