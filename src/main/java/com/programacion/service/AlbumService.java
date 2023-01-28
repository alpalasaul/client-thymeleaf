package com.programacion.service;

import com.programacion.model.Album;
import com.programacion.model.Singer;

import java.util.List;

public interface AlbumService {

    List<Album> getAll();
    Album findById(String id);
    void save(Album album);
    void delete(Integer id);
    void update(Integer id, Album album);

}
