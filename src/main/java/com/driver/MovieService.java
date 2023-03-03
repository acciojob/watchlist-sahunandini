package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    MovieRepository repository;
    //1
    public void addMovie(Movie movie){
        repository.addMovie(movie);
    }
    //2
    public void addDirector(Director director){
        repository.addDirector(director);
    }
    //3
    public void pairMovieAndDirector(String movieName,String directorName){
        repository.pairDirectorAndMovie(movieName,directorName);
    }
    //4
    public Movie getMovie(String movieName){
        return repository.getMovie(movieName);
    }
    //5
    public Director getDirector(String directorName){
        return repository.getDirector(directorName);
    }

    //6
    public List<String> getMoviesOfADirector(String directorName){
        return repository.getListOfMoviesOfADirector(directorName);
    }

    //7
    public List<String> showAllMovies(){
        return repository.getListOfAllMovies();
    }

    //8
    public void deleteADirector(String directorName){
        repository.deleteADirectorAndAllItsMovies(directorName);
    }

    //9
    public void deleteAllDirectors(){
        repository.deleteAllDirectorAndTheirMovies();
    }

}