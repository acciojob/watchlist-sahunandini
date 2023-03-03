package com.driver;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class MovieRepository {

    HashMap<String,Movie> movieDb=new HashMap<>();
    HashMap<String,Director> directorDb=new HashMap<>();
    HashMap<String, List<String>> directorMoviewDb = new HashMap<>();

    public void addMovie(Movie movie){
        String movieName=movie.getName();
        movieDb.put(movieName,movie);
    }

    public void addDirector(Director director){
        String directorName=director.getName();
        directorDb.put(directorName,director);
    }

    public void pairDirectorAndMovie(String movieName,String directorName){
        if(movieDb.containsKey(movieName) && directorDb.containsKey(directorName)){
            if(directorMoviewDb.containsKey(directorName)){
                directorMoviewDb.get(directorName).add(movieName);
            }
            else{
                directorMoviewDb.put(directorName,new ArrayList<>());
                directorMoviewDb.get(directorName).add(movieName);
            }
        }
    }

    public Movie getMovie(String movieName){
        if(movieDb.containsKey(movieName)){
            return movieDb.get(movieName);
        }
        else
            return null;
    }

    public Director getDirector(String directorName){
        if(directorDb.containsKey(directorName)){
            return directorDb.get(directorName);
        }
        else
            return null;
    }

    public List<String> getListOfMoviesOfADirector(String directorName){
        if(directorMoviewDb.containsKey(directorName)){
            return directorMoviewDb.get(directorName);
        }
        else
            return null;
    }

    public List<String> getListOfAllMovies(){
        List<String> allmovies = new ArrayList<>();
        for(String movies:movieDb.keySet()){
            allmovies.add(movies);
        }
        return allmovies;
    }
    //deletes a director from directorDB
    public void deleteDirectorFromDirectorDb(String directorName){
        if(directorDb.containsKey(directorName)){
            directorDb.remove(directorName);
        }
    }
    //deletes a director:List<Movies> pair from directorMovieDb
    public void deleteDirectorFromMovieDirectorDb(String directorName){
        if(directorMoviewDb.containsKey(directorName)){
            directorMoviewDb.remove(directorName);
        }
    }
    public void deleteADirectorAndAllItsMovies(String directorName){

        List<String> movies=getListOfMoviesOfADirector(directorName);
        deleteDirectorFromDirectorDb(directorName);
        deleteDirectorFromMovieDirectorDb(directorName);
        deleteMoviesFromMovieDB(movies);

    }
    public void deleteMoviesFromMovieDB(List<String> movies){
        for(String movie:movies){
            if(movieDb.containsKey(movie)){
                movieDb.remove(movie);
            }
        }
    }
    public void deleteAllDirectorAndTheirMovies(){

        //added all the directors from director db
        List<String> directors = new ArrayList<>();
        for(String director:directorDb.keySet()){
            directors.add(director);
        }
        //deleting all director and all of its records one by one
        for(String director:directors){
            deleteADirectorAndAllItsMovies(director);
        }
    }



}