package com.example.SchoolMangementProject.repo;

import com.example.SchoolMangementProject.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class StudentRepoClass {
    @Autowired
    private MongoTemplate mongoTemplate;
   public  Boolean saveStudent(Student student){
       Query query =new Query();
       mongoTemplate.insert(student);
       return  true;

   }
   public  Student findByUserId(String id){
       Query query =new Query(Criteria.where("userId").is(id));
       return  mongoTemplate.findOne(query,Student.class);

   }
    public  Boolean deleteStudent(String id){
        Query query =new Query();
        query.addCriteria(Criteria.where("_id").is(id));
        mongoTemplate.remove(query, Student.class);
        return  true;

    }
   //count student for perticular class
   public  long count_student(String classId){
       Query  query=new Query(Criteria.where("classId").is(classId));
       return mongoTemplate.count(query, Student.class);

   }
}
