package com.programacion.service;

import com.programacion.model.Singer;

import java.util.List;

public interface SingerService {

    List<Singer> getAll();
    Singer findById(String id);
    void save(Singer singer);
    void delete(Integer id);
    void update(Integer id, Singer singer);

}
