package com.ellixo.breizjug;

import com.ellixo.breizhjug.App;
import com.ellixo.breizhjug.Talk;
import com.ellixo.breizhjug.TalkService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = App.class)
@WebIntegrationTest
public class ApiTest {

    @Autowired
    private TalkService service;

    @Value("${local.server.port}")
    private int serverPort;

    @Test
    public void testService() {
        Talk talk = new Talk();
        talk.setTitre("Spring Boot");
        talk.setDescription("Desc");
        talk.setSpeaker("GLB");

        service.create(talk);
        assertEquals(service.list().size(), 1);
    }

    @Test
    public void testIntegration() {
        Talk talk = new Talk();
        talk.setTitre("Spring Boot");
        talk.setDescription("Desc");
        talk.setSpeaker("GLB");

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.postForObject("http://localhost:" + serverPort + "/api/talks", talk, String.class);
        assertEquals(restTemplate.getForObject("http://localhost:" + serverPort + "/api/talks", Talk[].class)[0], talk);
    }

}
