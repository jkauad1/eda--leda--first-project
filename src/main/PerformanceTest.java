package main;

import classes.Filme;
import classes.Ordenacao;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class PerformanceTest {
    public static void main(String[] args) throws Exception {

        long tempoInicial;
        Ordenacao ordenacao = new Ordenacao();

        Filme[] filmes;

        filmes = geraFilmesInversamenteOrdenados();

        tempoInicial = System.nanoTime();

        ordenacao.countingSort(filmes);

        System.out.println("Tempo (add inicio): " + (System.nanoTime() - tempoInicial) / 1000000000.0);
    }

    private static Filme[] geraFilmes() throws Exception {
        Scanner leitor = new Scanner(System.in);
        System.out.println("Informe quantos filmes você deseja gerar: ");
        int quantidadeDeFilmes = leitor.nextInt();

        if(quantidadeDeFilmes < 0){
            throw new Exception("Número inválido: A quantidade não pode ser negativa!");
        }

        if (quantidadeDeFilmes == 0){
            return new Filme[0];
        }

        Filme[] filmes = new Filme[quantidadeDeFilmes];

        for (int i = 0; i < quantidadeDeFilmes; i++) {
            filmes[i] = new Filme();
        }

        return filmes;
    }

    private static Filme[] geraFilmesOrdenados() throws Exception {
        Filme[] filmes = geraFilmes();
        Arrays.sort(filmes, Comparator.comparing(Filme::getNota)); // Ordena com base na nota
        return filmes;
    }

    private static Filme[] geraFilmesInversamenteOrdenados() throws Exception {
        Filme[] filmes = geraFilmesOrdenados();
        for (int i = 0; i < filmes.length / 2; i++) {
            Filme temp = filmes[i];
            filmes[i] = filmes[filmes.length - 1 - i];
            filmes[filmes.length - 1 - i] = temp;
        }
        return filmes;
    }
}
