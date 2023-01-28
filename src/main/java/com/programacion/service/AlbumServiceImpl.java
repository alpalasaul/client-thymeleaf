package com.programacion.service;

import com.programacion.model.Album;
import com.programacion.model.Singer;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@ApplicationScoped
public class AlbumServiceImpl implements AlbumService {

    private static final String URL = "http://localhost:8080/rest02/api/v1/album";

    @Inject
    private RestTemplate restTemplate;

    @Override
    public List<Album> getAll() {
        ResponseEntity<Album[]> res = restTemplate.getForEntity(URL, Album[].class);
        return List.of(res.getBody());
    }

    @Override
    public Album findById(String id) {
        ResponseEntity<Album> res = restTemplate.getForEntity(URL + "/" + id, Album.class);
        return res.getBody();
    }

    @Override
    public void save(Album album) {
        restTemplate.postForEntity(URL, album, Album.class);
    }

    @Override
    public void delete(Integer id) {
        restTemplate.delete(URL + "/" + id);
    }

    @Override
    public void update(Integer id, Album album) {
        restTemplate.put(URL + "/" + id, album, Album.class);
    }

}
