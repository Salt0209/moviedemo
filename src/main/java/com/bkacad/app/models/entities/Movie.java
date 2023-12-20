package com.bkacad.app.models.entities;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@NoArgsConstructor
@AllArgsConstructor
@Accessors(fluent = true,chain = true)
@Setter
@Getter
@Data
public class Movie {
    public int id;
    public String title;
    public String genre;
    public int yearOfRelease;

    public int getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public String getGenre() {
        return genre;
    }
    public int getYearOfRelease() {
        return yearOfRelease;
    }
}
