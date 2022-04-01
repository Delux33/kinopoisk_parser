package com.parser.kinopoisk.services;

import com.parser.kinopoisk.dto.Film;
import com.parser.kinopoisk.repos.FilmRepo;
import com.parser.kinopoisk.services.tools.ParserPage;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParserService {
    private final Logger logger = LoggerFactory.getLogger(ParserService.class.getName());
    private final String URL = "https://www.kinopoisk.ru/lists/movies/top250/";
    private final String MAIN_PAGE = "div[class=styles_contentSlot__2zPKt]";
    private final String FILM = "div[class=styles_root__3a8vf]";

    @Autowired
    ParserPage parserPage;

    @Autowired
    FilmRepo filmRepo;

    @Scheduled(cron = "0 */15 * * * *")
    private void parsePage() {
        Document page = parserPage.getPage(URL);

        Element topFilmsPage = page.selectFirst(MAIN_PAGE);
        Elements topFilms = topFilmsPage != null ? topFilmsPage.select(FILM) : null;

        if (topFilms != null) {
            List<Film> films = parserPage.getFilms(topFilms);
            logger.info("----------Page successfully parsed----------");
            filmRepo.saveAll(films);
        } else {
            logger.info("----------Page unsuccessfully parsed----------");
        }
    }
}
