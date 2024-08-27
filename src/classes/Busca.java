package classes;

import interfaces.Busca_IF;

public class Busca implements Busca_IF {

    @Override
    public Filme buscaLinearIterativa(Filme[] filmes, int nota) {
        for (int i = 0; i < filmes.length; i++){
            if (filmes[i].getNota() == nota){
                return filmes[i];
            }
        }
        return null;
    }

    @Override
    public Filme buscaLinearRecursiva(Filme[] filmes, int nota) {
        return null;
    }

    private Filme buscaLinearRecursivaAux(Filme[] filmes, int nota, int indice) {
        if (indice > filmes.length){
            return null;
        }
        if (filmes[indice].getNota() == nota){
            return filmes[indice];
        }
        return buscaLinearRecursivaAux(filmes, nota, indice + 1);
    }

    @Override
    public Filme buscaBinariaIterativa(Filme[] filmes, int nota) {
        int inicio_da_lista = 0;
        int final_da_lista = filmes.length - 1;

        while (inicio_da_lista <= final_da_lista){
            int meio_da_lista = (final_da_lista + inicio_da_lista) / 2;

            if (filmes[meio_da_lista].getNota() == nota ){
                return filmes[meio_da_lista];
            } else if (filmes[meio_da_lista].getNota() < nota) {
                inicio_da_lista = meio_da_lista + 1;
            }
            else {
                final_da_lista = meio_da_lista - 1;
            }
        }
        return null;
    }

    @Override
    public Filme buscaBinariaRecursiva(Filme[] filmes, int nota) {
        return buscaBinariaRecursivaAux(filmes, nota, 0, (filmes.length  - 1));
    }

    public Filme buscaBinariaRecursivaAux(Filme[] filmes, int nota, int inicio_da_lista, int final_da_lista) {

        if (inicio_da_lista > final_da_lista){
            return null;
        }

        int meio_da_lista = (final_da_lista + inicio_da_lista) / 2;

        if (filmes[meio_da_lista].getNota() == nota){
            return filmes[meio_da_lista];
        }
        if (filmes[meio_da_lista].getNota() < nota){
            return buscaBinariaRecursivaAux(filmes, nota, meio_da_lista + 1, final_da_lista);
        } else {
            return buscaBinariaRecursivaAux(filmes, nota, inicio_da_lista, meio_da_lista - 1);
        }
    }
}
