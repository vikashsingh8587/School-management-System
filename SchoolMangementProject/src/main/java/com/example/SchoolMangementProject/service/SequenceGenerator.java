package com.example.SchoolMangementProject.service;

import com.example.SchoolMangementProject.dto.DataSequence;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SequenceGenerator {
    @Autowired
    private MongoTemplate mongoTemplate;

    public  long generateSequence(String seq){

        Query query=new Query(Criteria.where("_id").is(seq));
        Update update =new Update().inc("seq",1);
        FindAndModifyOptions options=new FindAndModifyOptions().returnNew(true).upsert(true);
        DataSequence counter=mongoTemplate.findAndModify(query,update,options,DataSequence.class);

return  counter!=null ?counter.getSeq():1;
    }
}
