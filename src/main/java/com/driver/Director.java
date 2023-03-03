package com.driver;

public class Director {
    private String name;
    private int numberOfMovies;
    private double imdbRating;

    public Director(){

    }
    public Director(String name,int numOfMovies,double rating){
        this.name=name;
        this.numberOfMovies=numOfMovies;
        this.imdbRating=rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfMovies() {
        return numberOfMovies;
    }

    public void setNumberOfMovies(int numberOfMovies) {
        this.numberOfMovies = numberOfMovies;
    }

    public double getImdbRating() {
        return imdbRating;
    }

    public void setImdbRating(double imdbRating) {
        this.imdbRating = imdbRating;
    }
}