/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allstar;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author jingjunzhang
 */
public class Movie {
    private StringProperty mid;
    private StringProperty title;
    private StringProperty year;
    private StringProperty genres;
    private StringProperty lang;
    private StringProperty studio;
    private StringProperty rating;
    private StringProperty stars;
    private StringProperty director;
    private StringProperty awardM;
    private StringProperty awardYM;

    public Movie(String mid, String title, String year, String genres, String lang, String studio, String rating, String stars, String director, String awardM, String awardYM) {
        this.mid = new SimpleStringProperty(mid);
        this.title = new SimpleStringProperty(title);
        this.year = new SimpleStringProperty(year);
        this.genres = new SimpleStringProperty(genres);
        this.lang = new SimpleStringProperty(lang);
        this.studio = new SimpleStringProperty(studio);
        this.rating = new SimpleStringProperty(rating);
        this.stars = new SimpleStringProperty(stars);
        this.director = new SimpleStringProperty(director);
        this.awardM = new SimpleStringProperty(awardM);
        this.awardYM = new SimpleStringProperty(awardYM);
    }

    public StringProperty midProperty() {
        return mid;
    }
    
    public String getMid() {
        return mid.get();
    }

    public void setMid(String mid) {
        this.mid.set(mid);
    }

    public StringProperty titleProperty() {
        return title;
    }
    
    public String getTitle() {
        return title.get();
    }

    public void setTitle(String title) {
        this.title.set(title);
    }

    public StringProperty yearProperty() {
        return year;
    }
    
    public String getYear() {
        return year.get();
    }

    public void setYear(String year) {
        this.year.set(year);
    }

    public StringProperty genresProperty() {
        return genres;
    }
    
    public String getGenres() {
        return genres.get();
    }

    public void setGenres(String genres) {
        this.genres.set(genres);
    }

    public StringProperty langProperty() {
        return lang;
    }
    
    public String getLang() {
        return lang.get();
    }

    public void setLang(String lang) {
        this.lang.set(lang);
    }

    public StringProperty studioProperty() {
        return studio;
    }
    
    public String getStudio() {
        return studio.get();
    }

    public void setStudio(String studio) {
        this.studio.set(studio);
    }

    public StringProperty ratingProperty() {
        return rating;
    }
    
    public String getRating() {
        return rating.get();
    }

    public void setRating(String rating) {
        this.rating.set(rating);
    }

    public StringProperty starsProperty() {
        return stars;
    }
    
    public String getStars() {
        return stars.get();
    }

    public void setStars(String stars) {
        this.stars.set(stars);
    }

    public StringProperty directorProperty() {
        return director;
    }
    
    public String getDirector() {
        return director.get();
    }

    public void setDirector(String director) {
        this.director.set(director);
    }

    public StringProperty awardMProperty() {
        return awardM;
    }
    
    public String getAwardM() {
        return awardM.get();
    }

    public void setAwardM(String awardM) {
        this.awardM.set(awardM);
    }

    public StringProperty awardYMProperty() {
        return awardYM;
    }
    
    public String getAwardYM() {
        return awardYM.get();
    }

    public void setAwardYM(String awardYM) {
        this.awardYM.set(awardYM);
    }
    
    
}
