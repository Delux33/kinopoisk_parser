package com.parser.kinopoisk.services;

import com.parser.kinopoisk.dto.Film;
import com.parser.kinopoisk.repos.FilmRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

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

    public List<String> getDates() {
        List<String> dateFilms = new ArrayList<>();
        Iterable<Film> allFilms = filmRepo.findAll();

        for (Film film : allFilms) {
            dateFilms.add(film.getDate());
        }

        dateFilms = getDateFilmsWithoutRepeats(dateFilms);
        Collections.reverse(dateFilms);
        return dateFilms;
    }

    private List<String> getDateFilmsWithoutRepeats(List<String> dateFilms) {
        return dateFilms
                .stream()
                .distinct()
                .collect(Collectors.toList());
    }
}
