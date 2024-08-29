package classes;

import interfaces.Busca_IF;

import java.util.*;

public class Menu {

    public static final Scanner leitor = new Scanner(System.in);

    public static void menu(){

        List<Filme> filmes = new ArrayList<>();
        Ordenacao ordenador = new Ordenacao();
        Busca_IF buscador = new Busca();

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

                    System.out.println("Deseja ordenar por qual método: \n1- BubbleSort " +
                            "\n2- InsertionSort " +
                            "\n3- MergeSort");
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
                        break;
                case 2:
                    System.out.println("Qual método de busca deseja usar: \n1- Busca Linear iterativa" +
                            "\n2- Busca Linear recursiva" +
                            "\n3- Busca Binária iterativa" +
                            "\n4- Busca Binária recursiva");

                    menu = leitor.nextInt();

                    System.out.println("Por qual nota deseja procurar: (1 - 5)");
                    int nota = leitor.nextInt();
                    Filme resultado = null;

                    switch (menu){
                        case 1:
                            resultado = buscador.buscaLinearIterativa(filmes, nota);
                            break;
                        case 2:
                            resultado = buscador.buscaLinearRecursiva(filmes, nota);
                            break;
                        case 3:
                            resultado = buscador.buscaBinariaIterativa(filmes, nota);
                            break;
                        case 4:
                            resultado = buscador.buscaBinariaRecursiva(filmes, nota);
                            break;
                        default:
                            System.out.println("Número inválido, digite um dos números do menu");
                    }

                    if(resultado != null){
                        System.out.println("O filme encontrado é: " + resultado);
                    }
                    else{
                        System.out.println("Filme não encontrado!");
                    }

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



    private static List<Filme> geraFilmes(){

        System.out.println("Informe quantos filmes você deseja gerar: ");
        int quantidadeDeFilmes = leitor.nextInt();

        List<Filme> filmes = new ArrayList<>(quantidadeDeFilmes);

        for (int i = 0; i < quantidadeDeFilmes; i++){
            filmes.add(new Filme());
        }

        return filmes;
    }

}
