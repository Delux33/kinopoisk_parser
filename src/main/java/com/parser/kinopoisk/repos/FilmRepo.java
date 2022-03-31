package com.parser.kinopoisk.repos;

import com.parser.kinopoisk.dto.Film;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmRepo extends CrudRepository<Film, Long> {
    Iterable<Film> findByDateEquals(String date);
}
