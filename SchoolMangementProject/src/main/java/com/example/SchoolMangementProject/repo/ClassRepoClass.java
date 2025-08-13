package com.example.SchoolMangementProject.repo;

import com.example.SchoolMangementProject.entity.ClassEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class ClassRepoClass {
    @Autowired
    private MongoTemplate mongoTemplate;
    public  Boolean saveClass(ClassEntity classes){
        Query query=new Query();
        mongoTemplate.insert(classes);
        return  true;
    }
    public  Boolean deleteClass(String id){
        Query query =new Query();
        query.addCriteria(Criteria.where("_id").is(id));
        mongoTemplate.remove(query, ClassEntity.class);
        return  true;

    }

}
