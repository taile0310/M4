package com.example.exercise2.service;

import com.example.exercise2.model.Song;

import java.util.List;

public interface ISongService {
    List<Song> findAll();

    Song findById(int id);

    void save(Song song);
}
