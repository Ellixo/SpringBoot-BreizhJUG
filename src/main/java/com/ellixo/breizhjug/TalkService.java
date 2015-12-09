package com.ellixo.breizhjug;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TalkService {

    @Autowired
    private TalkRepository repository;

    public void create(Talk talk) {
        repository.save(talk);
    }

    public List<Talk> list() {
        return repository.findAll();
    }

}
