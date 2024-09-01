package classes;

import interfaces.Busca_IF;

public class Busca implements Busca_IF {

    @Override
    public Filme buscaLinear_iterativa(Filme[] filmes, int nota) {

        for (Filme f: filmes){
            if(f.getNota() == nota){
                return f;
            }
        }
        return null;// implementar erro
    }

    @Override
    public Filme buscaLinear_recursiva(Filme[] filmes, int nota) {
        return buscaLinear_recursivaAux(filmes, nota, 0);
    }

    private Filme buscaLinear_recursivaAux(Filme[] filmes, int nota, int indice) {
        if (indice > filmes.length){
            return null; // implementar excpetion
        }
        if (filmes[indice].getNota() == nota){
            return filmes[indice];
        }
        return buscaLinear_recursivaAux(filmes, nota, indice + 1);
    }

    @Override
    public Filme buscaBinaria_iterativa(Filme[] filmes, int nota) {
        int inicio_da_lista = 0;
        int final_da_lista = filmes.length - 1;

        while (inicio_da_lista <= final_da_lista){
            int meio_da_lista = (final_da_lista + inicio_da_lista) / 2;

            if (filmes[meio_da_lista].getNota() == nota ){
                return filmes[meio_da_lista];
            } else if (filmes[meio_da_lista].getNota() < nota) {
                final_da_lista = meio_da_lista - 1;
            }
            else {
                inicio_da_lista = meio_da_lista + 1;
            }
        }
        return null;
    }

    @Override
    public Filme buscaBinaria_recursiva(Filme[] filmes, int nota) {
        return buscaBinaria_recursivaAux(filmes, nota, 0, (filmes.length) - 1);
    }

    public Filme buscaBinaria_recursivaAux(Filme[] filmes, int nota, int inicio_da_lista, int final_da_lista) {

        if (inicio_da_lista > final_da_lista) {
            return null;
        }

        int meio_da_lista = (final_da_lista + inicio_da_lista) / 2;

        if (filmes[meio_da_lista].getNota() == nota) {
            return filmes[meio_da_lista];
        }
        if (filmes[meio_da_lista].getNota() < nota) {
            return buscaBinaria_recursivaAux(filmes, nota, inicio_da_lista, meio_da_lista - 1);
        } else {
            return buscaBinaria_recursivaAux(filmes, nota, meio_da_lista + 1, final_da_lista);
        }

    }
}
