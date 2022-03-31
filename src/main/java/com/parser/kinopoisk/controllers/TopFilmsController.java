package com.parser.kinopoisk.controllers;

import com.parser.kinopoisk.dto.Film;
import com.parser.kinopoisk.services.ParserService;
import com.parser.kinopoisk.services.TopFilmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Set;

@Controller
public class TopFilmsController {

    @Autowired
    TopFilmsService topFilmsService;

    @GetMapping
    public String getMainPage(Model model) {
        Set<String> dates = topFilmsService.getDates();

        model.addAttribute("dates", dates);

        return "main";
    }

    @GetMapping("/tops/{date}")
    public String getTopFilmsForDate(@PathVariable String date,
                                     Model model) {
        Set<String> dates = topFilmsService.getDates();
        Iterable<Film> topFilms = topFilmsService.getTopFilms(date);

        model.addAttribute("topFilms", topFilms);
        model.addAttribute("dates", dates);

        return "topFilms";
    }
}
