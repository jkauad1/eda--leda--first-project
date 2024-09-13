package main;

import classes.Filme;
import classes.Ordenacao;
import classes.Busca;
import static classes.Menu.geraFilmes;
import static classes.Menu.printFilmes;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class PerformanceTest {
    public static void main(String[] args) throws Exception {

        Ordenacao ordenacao = new Ordenacao();
        //Busca buscador = new Busca();

        Filme[] filmes = geraFilmes();

        // Testa para desordenada
        System.out.println("Desordenada:");
        medirTempoOrdenacao(filmes, ordenacao); // Testa a lista desordenada
        //medirTempoBusca(filmes, buscador);

        // Testa para ordenada
        System.out.println("Ordenada:");
        Arrays.sort(filmes);
        medirTempoOrdenacao(filmes, ordenacao); // Testa a lista ordenada
        //medirTempoBusca(filmes, buscador);

        // Testa para reversamente ordenada
        System.out.println("Reversamente Ordenada:");
        Arrays.sort(filmes, Collections.reverseOrder());
        medirTempoOrdenacao(filmes, ordenacao);
        //medirTempoBusca(filmes, buscador);
    }

    private static void medirTempoOrdenacao(Filme[] filmes, Ordenacao ordenacao) {
        long tempoInicial = System.nanoTime();

        // printFilmes(filmes); teste pra ve se ta funcionando

        // Mude o método
        ordenacao.insertionSort(filmes);

        long tempoFinal = System.nanoTime();
        double tempoSegundos = (tempoFinal - tempoInicial) / 1000000000.0;

        System.out.println("Tempo de Ordenação: " + tempoSegundos + " segundos");
    }

    private static void medirTempoBusca(Filme[] filmes, Busca busca) throws Exception {
        long tempoInicial = System.nanoTime();

        // printFilmes(filmes); teste pra ve se ta funcionando

        // Mude o método
        busca.buscaBinaria_iterativa(filmes, 4);

        long tempoFinal = System.nanoTime();
        double tempoSegundos = (tempoFinal - tempoInicial) / 1000000000.0;

        System.out.println("Tempo de Busca: " + tempoSegundos + " segundos");
    }
}
