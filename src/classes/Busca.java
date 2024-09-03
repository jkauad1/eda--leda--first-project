package classes;

import interfaces.Busca_IF;

public class Busca implements Busca_IF {

    @Override
    public boolean checaVetorOrdenado(Filme[] filmes) {

        if (filmes.length < 2){
            return true;
        }

        for (int i = 0; i < filmes.length - 1; i++){

            if (filmes[i + 1].compareTo(filmes[i]) < 0){
                return false;
            }
        }
        return true;
    }

    @Override
    public Filme buscaLinear_iterativa(Filme[] filmes, int nota) throws Exception {

        if (nota < 0) {
            throw new Exception("Nota inválida: a nota não pode ser negativa.");
        }

        for (Filme f : filmes) {
            if (f.getNota() == nota) {
                return f;
            }
        }
        return null;
    }

    @Override
    public Filme buscaLinear_recursiva(Filme[] filmes, int nota) throws Exception {

        if (nota < 0) {
            throw new Exception("Nota inválida: a nota não pode ser negativa.");
        }
        return buscaLinear_recursivaAux(filmes, nota, 0);
    }

    private Filme buscaLinear_recursivaAux(Filme[] filmes, int nota, int indice) throws Exception {

        if (indice >= filmes.length) {
            return null; // Retorna null se o índice exceder o tamanho do vetor.
        }

        if (filmes[indice].getNota() == nota) {
            return filmes[indice];
        }
        return buscaLinear_recursivaAux(filmes, nota, indice + 1);
    }

    @Override
    public Filme buscaBinaria_iterativa(Filme[] filmes, int nota) throws Exception {

        if (nota < 0) {
            throw new Exception("Nota inválida: a nota não pode ser negativa.");
        }

        int inicio = 0;
        int fim = filmes.length - 1;

        while (inicio <= fim) {
            int meio = (inicio + fim) / 2;

            if (filmes[meio].getNota() == nota) {
                return filmes[meio];
            } else if (filmes[meio].getNota() < nota) {
                inicio = meio + 1;
            } else {
                fim = meio - 1;
            }
        }
        return null;
    }

    @Override
    public Filme buscaBinaria_recursiva(Filme[] filmes, int nota) throws Exception {

        if (nota < 0) {
            throw new Exception("Nota inválida: a nota não pode ser negativa.");
        }

        return buscaBinaria_recursivaAux(filmes, nota, 0, filmes.length - 1);
    }


    private Filme buscaBinaria_recursivaAux(Filme[] filmes, int nota, int inicio, int fim) throws Exception {

        if (inicio > fim) {
            return null;
        }

        int meio = (inicio + fim) / 2;

        if (filmes[meio].getNota() == nota) {
            return filmes[meio];
        } else if (filmes[meio].getNota() < nota) {
            return buscaBinaria_recursivaAux(filmes, nota, meio + 1, fim);
        } else {
            return buscaBinaria_recursivaAux(filmes, nota, inicio, meio - 1);
        }
    }

    @Override
    public Filme buscaLinear_iterativa_duasPontas(Filme[] filmes, int nota) throws Exception {
        return null;
    }
}
