package com.programacion.service;

import com.programacion.model.Album;
import com.programacion.model.Singer;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@ApplicationScoped
public class SingerServiceImpl implements SingerService {

    private static final String URL = "http://localhost:8080/rest02/api/v1/singer";

    @Inject
    private RestTemplate restTemplate;

    @Override
    public List<Singer> getAll() {
        ResponseEntity<Singer[]> res = restTemplate.getForEntity(URL, Singer[].class);
        return List.of(res.getBody());
    }

    @Override
    public Singer findById(String id) {
        ResponseEntity<Singer> res = restTemplate.getForEntity(URL + "/" + id, Singer.class);
        return res.getBody();
    }

    @Override
    public void save(Singer singer) {
        restTemplate.postForEntity(URL, singer, Singer.class);
    }

    @Override
    public void delete(Integer id) {
        restTemplate.delete(URL + "/" + id);
    }

    @Override
    public void update(Integer id, Singer singer) {
        restTemplate.put(URL + "/" + id, singer, Singer.class);
    }


}
