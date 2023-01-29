package com.programacion.service;

import com.programacion.model.Book;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.springframework.http.HttpMethod.GET;

@ApplicationScoped
public class BookServiceImpl implements BookService {

//    private static final String URL = "http://localhost:8080/rest02/api/v1/album";
    private static final String URL = "http://localhost:8080/api/book";

    @Inject
    private RestTemplate restTemplate;

    @Override
    public List<Book> getAll() {
        var response = restTemplate.exchange(
                URL,
                GET,
                null,
                new ParameterizedTypeReference<List<Book>>() {
                }
        );
        return response.getBody();
    }

    @Override
    public Book findById(String id) {
        ResponseEntity<Book> res = restTemplate.getForEntity(URL + "/" + id, Book.class);
        return res.getBody();
    }

    @Override
    public void save(Book album) {
        restTemplate.postForEntity(URL, album, Book.class);
    }

    @Override
    public void delete(Integer id) {
        restTemplate.delete(URL + "/" + id);
    }

    @Override
    public void update(Integer id, Book album) {
        restTemplate.put(URL + "/" + id, album, Book.class);
    }

}
