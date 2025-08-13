package com.example.SchoolMangementProject.service;

import com.example.SchoolMangementProject.entity.Photo;
import com.example.SchoolMangementProject.repo.PhotoRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
@Data
@Service
@AllArgsConstructor

public class PhotoService {
@Autowired
    private final PhotoRepository photoRepository;
@Autowired
private  SequenceGenerator sequenceGenerator;



    public Photo savePhoto(MultipartFile file) throws Exception {
        Photo photo = new Photo();
        photo.setName(file.getOriginalFilename());
        photo.setContentType(file.getContentType());
        photo.setImageData(file.getBytes());
        long seq=sequenceGenerator.generateSequence("Photo_sequence");
        String ids= String.format("PH%03d",seq);
        photo.setId(ids);
        Photo savedPhoto = photoRepository.save(photo);
        return savedPhoto;
    }

    public Photo getPhoto(String id) {
        return photoRepository.findById(id).orElse(null);
    }
}
