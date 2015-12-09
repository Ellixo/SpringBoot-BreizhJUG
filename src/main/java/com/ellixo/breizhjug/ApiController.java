package com.ellixo.breizhjug;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/talks")
public class ApiController {

    @Autowired
    private TalkService service;

    @RequestMapping(method = RequestMethod.POST)
    public void createTalk(@RequestBody Talk talk) {
        service.create(talk);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Talk> list() {
        return service.list();
    }

}