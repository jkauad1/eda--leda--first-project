package classes;

import java.util.*;

public class Menu {
    public static void menu(){

        System.out.println("1 - Procurar filme" +
                           "2 - Ordenar filmes." +
                           "3 - Gerar filmes." +
                           "8 - Encerrar programa.");

        int sair = 1;

        List<Filme> filmes = null;

        while (sair != 0){
            int menu = leitor.nextInt();

            switch (menu){
                case 1:

                case 2:
                    ordenaFilmes(filmes);
                    break;
                case 3:
                    filmes = geraFilmes();
                    break;
                case 4:
                    for (int i = 0; i < filmes.size(); i++){
                        System.out.println(filmes.get(i));
                    }
                case 8:
                    sair = 0;
            }
        }
    }

    public static  Scanner leitor = new Scanner(System.in);

    public static List<Filme> geraFilmes(){
        List<Filme> filmes = new ArrayList<>();

        System.out.println("Informe quantos filmes você deseja gerar: ");
        int quantidadeDeFilmes = leitor.nextInt();

        for (int i = 0; i < quantidadeDeFilmes; i++){
            Filme filme = new Filme();
            filmes.add(filme);
        }

        return filmes;
    }

    public static List<Filme> ordenaFilmes(List<Filme> listaDeFilmes){
        if (listaDeFilmes == null){
            System.out.println("Não há nenhum filme para ordenar.");
        }
        else {
            Collections.sort(listaDeFilmes);
        }
        return listaDeFilmes;
    }
}
