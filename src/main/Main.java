package main;

import classes.Busca;
import classes.Filme;
import classes.Ordenacao;
import interfaces.Busca_IF;

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
        Ordenacao ordenador = new Ordenacao();

        for (Filme m : filmes){
            lista.add(m);
        }

        int size = 10000;

        for(int i = 0; i < size; i++){  // For para a criação de de pessoas e adicionar a lista de acordo com o "size";
            Filme p = new Filme();
            lista.add(p);
        }



        Busca_IF busca = new Busca();
        Filme filmeEncontrado;
        filmeEncontrado = busca.buscaLinearRecursiva(filmes, 8);

            if (filmeEncontrado != null) {
                System.out.println("Filme encontrado: " + filmeEncontrado);
            } else {
                System.out.println("Filme não encontrado.");
            }

        System.out.println("Ordem original: " + lista);

        System.out.println("Ordem organizada: ");
        ordenador.bubbleSort(lista);
        System.out.println(lista);
        }
    }