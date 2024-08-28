package classes;

import java.util.*;

public class Menu {
    public static void menu(){

        List<Filme> filmes = new ArrayList<>();
        Ordenacao ordenador = new Ordenacao();

        label:
        while (true){
            System.out.println("1 - Ordenar filmes" +
                    "\n2 - Procurar filmes." +
                    "\n3 - Gerar filmes." +
                    "\n4 - Printar filmes" +
                    "\n8 - Encerrar programa.");

            int menu = leitor.nextInt();
            switch (menu){
                case 1:

                    System.out.println("Deseja ordenar por qual método: \n1- BubbleSort \n2- InsertionSort \n3- MergeSort");
                    menu = leitor.nextInt();

                        switch (menu){
                            case 1:
                                ordenador.bubbleSort(filmes);
                                System.out.println("Filmes ordenados com bubbleSort");
                                break;
                            case 2:
                                ordenador.insertionSort(filmes);
                                System.out.println("Filmes ordenados com insertionSort");
                                break;
                            case 3:
                                ordenador.mergeSort(filmes);
                                System.out.println("Filmes ordenados com mergeSort");
                                break;
                            default:
                                System.out.println("Número inválido, digite um dos números do menu");
                                break;
                        }
                case 2:
                    break;
                case 3:
                    filmes = geraFilmes();
                    break;
                case 4:
                    for (Filme f : filmes) {
                        System.out.println(f);
                    }
                    break;

                default:
                    System.out.println("Número inválido, digite um dos números do menu");
                    break;
                case 8:
                    break label;
            }
        }
    }

    public static Scanner leitor = new Scanner(System.in);

    private static List<Filme> geraFilmes(){
        List<Filme> filmes = new ArrayList<>();

        System.out.println("Informe quantos filmes você deseja gerar: ");
        int quantidadeDeFilmes = leitor.nextInt();

        for (int i = 0; i < quantidadeDeFilmes; i++){
            Filme filme = new Filme();
            filmes.add(filme);
        }

        return filmes;
    }

}
