package classes;

public class Movie implements Comparable<Movie> {
    private String name;
    private int score;
    private int year;

    public Movie(String name, int score, int year) {
        this.name = name;
        this.score = score;
        this.year = year;
    }

    public String toString(){
        return "Name: " + this.name + " (" + this.year + ")" + " Score: " + this.score;
    }

    @Override
    public int compareTo(Movie m) {
        if (this.score != m.score){
            return Integer.compare(m.score, this.score);
        }
        else if (this.year != m.year) {
            return Long.compare(this.year, m.year);
        }
        else {
            return this.name.compareTo(m.name);
        }
    }
}
