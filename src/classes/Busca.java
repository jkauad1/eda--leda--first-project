package classes;

import interfaces.Busca_IF;

import java.util.List;

public class Busca implements Busca_IF {

    @Override
        public Filme buscaLinearIterativa(List<Filme> filmes, int nota) {

        for (Filme f: filmes){
            if(f.getNota() == nota){
                return f;
            }
        }
        return null;// implementar erro
    }

    @Override
    public Filme buscaLinearRecursiva(List<Filme> filmes, int nota) {
        return buscaLinearRecursivaAux(filmes, nota, 0);
    }

    private Filme buscaLinearRecursivaAux(List<Filme> filmes, int nota, int indice) {
        if (indice > filmes.size()){
            return null; // implementar excpetion
        }
        if (filmes.get(indice).getNota() == nota){
            return filmes.get(indice);
        }
        return buscaLinearRecursivaAux(filmes, nota, indice + 1);
    }

    @Override
    public Filme buscaBinariaIterativa(List<Filme> filmes, int nota) {
        int inicio_da_lista = 0;
        int final_da_lista = filmes.size() - 1;

        while (inicio_da_lista <= final_da_lista){
            int meio_da_lista = (final_da_lista + inicio_da_lista) / 2;

            if (filmes.get(meio_da_lista).getNota() == nota ){
                return filmes.get(meio_da_lista);
            } else if (filmes.get(meio_da_lista).getNota() < nota) {
                final_da_lista = meio_da_lista - 1;
            }
            else {
                inicio_da_lista = meio_da_lista + 1;
            }
        }
        return null;
    }

    @Override
    public Filme buscaBinariaRecursiva(List<Filme> filmes, int nota) {
        return buscaBinariaRecursivaAux(filmes, nota, 0, (filmes.size()  - 1));
    }

    public Filme buscaBinariaRecursivaAux(List<Filme> filmes, int nota, int inicio_da_lista, int final_da_lista) {

        if (inicio_da_lista > final_da_lista) {
            return null;
        }

        int meio_da_lista = (final_da_lista + inicio_da_lista) / 2;

        if (filmes.get(meio_da_lista).getNota() == nota) {
            return filmes.get(meio_da_lista);
        }
        if (filmes.get(meio_da_lista).getNota() > nota) {
            return buscaBinariaRecursivaAux(filmes, nota, meio_da_lista + 1, final_da_lista);
        } else {
            return buscaBinariaRecursivaAux(filmes, nota, inicio_da_lista, meio_da_lista - 1);
        }

    }
}
