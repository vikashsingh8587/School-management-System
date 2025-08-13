package com.example.SchoolMangementProject.controller;


import com.example.SchoolMangementProject.entity.Photo;
import com.example.SchoolMangementProject.service.PhotoService;
import lombok.Data;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
@Data
@RestController
@RequestMapping("/photos")
public class PhotoController {

//    private final PhotoService photoService;
//
//
//    @PostMapping("/upload")
//    public ResponseEntity<String> uploadPhoto(@RequestParam("file") MultipartFile file) throws Exception {
//        System.out.println("upload");
//        String id = photoService.savePhoto(file);
//        return ResponseEntity.ok("Photo uploaded with ID: " + id);
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<byte[]> getPhoto(@PathVariable String id) {
//        Photo photo = photoService.getPhoto(id);
//        if (photo == null) {
//            return ResponseEntity.notFound().build();
//        }
//        return ResponseEntity.ok()
//                .contentType(MediaType.valueOf(photo.getContentType()))
//                .body(photo.getImageData());
//}
}
