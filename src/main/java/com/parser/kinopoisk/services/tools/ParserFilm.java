package com.parser.kinopoisk.services.tools;

import com.parser.kinopoisk.dto.Film;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class ParserFilm {
    private final String POSITION_HTML = "span[class=styles_position__OkHEm]";
    private final String RATING_HTML = "span[class=styles_kinopoiskValuePositive__1G4F6 styles_kinopoiskValue__2oNdS]";
    private final String NUMBER_OF_VOTES_HTML = "span[class=styles_kinopoiskCount__1DPG7]";
    private final String ABOUT_FILM_HTML = "span[class=desktop-list-main-info_secondaryText__1ov2X]";
    private final String RUSSIAN_NAME_HTML = "span[class=styles_mainTitle__3Bgao styles_activeMovieTittle__1yPIb]";
    private final Pattern searchEnglishName = Pattern.compile(".*[^\\d],");
    private final Pattern searchReleaseYear = Pattern.compile("\\d{4}");

    public Film getFilm(Element elementFilm) {
        String position = getTextFromHtml(elementFilm, POSITION_HTML);
        String aboutFilm = getTextFromHtml(elementFilm, ABOUT_FILM_HTML);
        String rating = getTextFromHtml(elementFilm, RATING_HTML);
        String numberOfVotes = getTextFromHtml(elementFilm, NUMBER_OF_VOTES_HTML);

        String name = getOriginalName(elementFilm, aboutFilm);
        String releaseYear = getReleaseYear(aboutFilm);
        String date = getDate();

        return new Film(position, name, rating, releaseYear, numberOfVotes, date);
    }

    private String getTextFromHtml(Element elementFilm, String html) {
        return elementFilm.select(html).text();
    }

    private String getOriginalName(Element elementFilm, String aboutFilm) {
        Matcher englishName = searchEnglishName.matcher(aboutFilm);

        if (englishName.find()) {
            return getEnglishName(englishName);
        } else {
            return getRussianName(elementFilm);
        }
    }

    private String getEnglishName(Matcher englishName) {
        String name = englishName.group();
        //in example: Schindler's List,
        //out result: Schindler's List
        return name.substring(0, name.length() - 1);
    }

    private String getRussianName(Element elementFilm) {
        return getTextFromHtml(elementFilm, RUSSIAN_NAME_HTML);
    }

    private String getReleaseYear(String aboutFilm) {
        Matcher releaseYear = searchReleaseYear.matcher(aboutFilm);
        if (releaseYear.find()) {
            return releaseYear.group();
        }
        return null;
    }

    private String getDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        return sdf.format(Calendar.getInstance().getTime());
    }
}
