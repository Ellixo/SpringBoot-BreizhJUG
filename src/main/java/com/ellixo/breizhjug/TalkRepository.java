package com.ellixo.breizhjug;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface TalkRepository extends MongoRepository<Talk,String> {

    public Talk findBySpeaker(String speaker);

}
