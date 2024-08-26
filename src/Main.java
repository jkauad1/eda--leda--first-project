import classes.Movie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Movie movie1 = new Movie("Jurassic Park", 9, 1993);
        Movie movie2 = new Movie("Jurassic World", 8, 2015);
        Movie movie3 = new Movie("Jurassic World: Dominion",7, 2022);

        Movie[] movies = {movie1, movie2, movie3};

        List<Movie> list = new ArrayList<>();

        for (Movie m : movies){
            list.add(m);
        }

        System.out.println("Original order: " +
                            list);

        System.out.println("Organized order: ");
        Collections.sort(list);
        System.out.println(list);
        }
    }