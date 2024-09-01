package classes;

import interfaces.Busca_IF;

import java.util.*;

public class Menu {

    public static final Scanner leitor = new Scanner(System.in);
    public static int menu;

    public static void menu() throws Exception {

        Filme[] filmes = null;
        Filme[] clone = null;
        Ordenacao ordenador = new Ordenacao();
        Busca_IF buscador = new Busca();

        label:
        while (true){
            System.out.println("""
                    1 - Gerar filmes.
                    2 - Ordenar filmes.
                    3 - Procurar filmes.
                    4 - Printar filmes
                    5 - Encerrar programa.""");

            int menu = leitor.nextInt();
            switch (menu){
                case 1:
                    filmes = geraFilmes();
                    clone = filmes.clone();
                    break;
                case 2:
                    ordenaFilmes(filmes, clone, ordenador);
                    break;
                case 3:
                    procurarFilmes(filmes, buscador);
                    break;
                case 4:
                    printFilmes(filmes);
                    break;

                default:
                    System.out.println("Número inválido, digite um dos números do menu.");
                    break;
                case 5:
                    break label;
            }
        }
    }

    private static void ordenaFilmes(Filme[] filmes, Filme[] clone, Ordenacao ordenador){

        if (isEmpty(filmes)){
            System.out.println("Lista vazia, gere filmes primeiro!");
            return;
        }

        System.out.println("""
                            Selecione o método que deseja usar:
                            1- BubbleSort
                            2- InsertionSort
                            3- SelectionSort
                            4- MergeSort
                            5- quickSort
                            6- countingSort
                            7- Restaurar sequência original
                            """);

        menu = leitor.nextInt();

        switch (menu){
            case 1:
                ordenador.bubbleSort(filmes);
                System.out.println("Filmes ordenados com bubbleSort.");
                break;
            case 2:
                ordenador.insertionSort(filmes);
                System.out.println("Filmes ordenados com insertionSort.");
                break;
            case 3:
                ordenador.selectionSort(filmes);
                System.out.println("Filmes ordenados com selectionSort");
                break;
            case 4:
                ordenador.mergeSort(filmes);
                System.out.println("Filmes ordenados com mergeSort.");
                break;
            case 5:
                ordenador.quickSort(filmes);
                System.out.println("Filmes ordenados com quickSort.");
                break;
            case 6:
                ordenador.countingSort(filmes);
                System.out.println("Filmes ordenados com CountingSort.");
                break;
            case 7:
                System.arraycopy(clone, 0, filmes, 0, clone.length);
                System.out.println("Sequência original restaurada.");
                break;
            default:
                System.out.println("Número inválido, digite um dos números do menu.");
                break;
        }
    }

    private static void procurarFilmes(Filme[] filmes, Busca_IF buscador) throws Exception {

        if (isEmpty(filmes)){
            System.out.println("Lista vazia, gere filmes primeiro!");
            return;
        }

        System.out.println("""
                            Selecione o método de busca que deseja usar:
                            1- Busca Linear iterativa.
                            2- Busca Linear recursiva.
                            3- Busca Binária iterativa.
                            4- Busca Binária recursiva.
                            """);

        menu = leitor.nextInt();

        System.out.println("Selecione a nota que deseja procurar: (1 - 5)");
        int nota = leitor.nextInt();
        Filme resultado = null;

        switch (menu){
            case 1:
                resultado = buscador.buscaLinear_iterativa(filmes, nota);
                break;
            case 2:
                resultado = buscador.buscaLinear_recursiva(filmes, nota);
                break;
            case 3:
                resultado = buscador.buscaBinaria_iterativa(filmes, nota);
                break;
            case 4:
                resultado = buscador.buscaBinaria_recursiva(filmes, nota);
                break;
            default:
                System.out.println("Número inválido, digite um dos números do menu.");
        }

        if(resultado != null){
            System.out.println("O filme encontrado é: " + resultado);
        }
        else{
            System.out.println("Filme não encontrado!");
        }

    }

    private static Filme[] geraFilmes() {
        Scanner leitor = new Scanner(System.in);
        System.out.println("Informe quantos filmes você deseja gerar: ");
        int quantidadeDeFilmes = leitor.nextInt();

        if (quantidadeDeFilmes == 0){
            return new Filme[0];
        }

        Filme[] filmes = new Filme[quantidadeDeFilmes];

        for (int i = 0; i < quantidadeDeFilmes; i++) {
            filmes[i] = new Filme();
        }

        return filmes;
    }

    private static boolean isEmpty(Filme[] filmes) {
        return filmes == null || filmes.length == 0;
    }

    private static void printFilmes(Filme[] filmes){

        if (isEmpty(filmes)){
            System.out.println("Lista vazia, gere filmes primeiro!");
            return;
        }

        if (filmes != null){
            for (Filme f : filmes){
                System.out.println(f);
            }
        }
        else{
            System.out.println("Lista Vazia!");
        }
    }
}


