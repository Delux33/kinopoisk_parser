package com.parser.kinopoisk.services;

import com.parser.kinopoisk.dto.Film;
import com.parser.kinopoisk.repos.FilmRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class TopFilmsService {
    private final Logger logger = LoggerFactory.getLogger(TopFilmsService.class.getName());

    @Autowired
    FilmRepo filmRepo;

    @Cacheable(cacheNames = "films")
    public Iterable<Film> getTopFilms(String date) {
        logger.info("--------Searching the database for all movies on a specific date--------");

        if (date != null && !date.isEmpty()) {
            return filmRepo.findByDateEquals(date);
        }
        return null;
    }

    public Set<String> getDates() {
        Set<String> dateFilms = new HashSet<>();
        Iterable<Film> allFilms = filmRepo.findAll();

        for (Film film : allFilms) {
            dateFilms.add(film.getDate());
        }
        return dateFilms;
    }
}
