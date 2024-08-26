import classes.Filme;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Filme filme1 = new Filme("Jurassic Park", 9, 1993);
        Filme filme2 = new Filme("Jurassic World", 8, 2015);
        Filme filme3 = new Filme("Jurassic World: Dominion",7, 2022);

        Filme[] filmes = {filme1, filme2, filme3};

        List<Filme> lista = new ArrayList<>();

        for (Filme m : filmes){
            lista.add(m);
        }

        System.out.println("Ordem original: " +
                            lista);

        System.out.println("Ordem organizada: ");
        Collections.sort(lista);
        System.out.println(lista);
        }
    }