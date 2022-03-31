package com.parser.kinopoisk.services.tools;

import com.parser.kinopoisk.dto.Film;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Service
public class ParserPage {
    private final Logger logger = LoggerFactory.getLogger(ParserPage.class.getName());
    private int count = 0;

    @Autowired
    ParserFilm parserFilm;

    public Document getPage(String url) {
        try {
            int timeout = 20000;
            return Jsoup.parse(new URL(url), timeout);
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
        return null;
    }

    public List<Film> getFilms(Elements topFilms) {
        List<Film> films = new ArrayList<>();

        for (Element elementFilm : topFilms) {
            Film film = parserFilm.getFilm(elementFilm);
            films.add(count, film);
            count++;

            if (count == 10) {
                count = 0;
                break;
            }
        }
        return films;
    }
}
