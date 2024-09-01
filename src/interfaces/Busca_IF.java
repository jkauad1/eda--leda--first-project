package interfaces;

import classes.Filme;

public interface Busca_IF {

    boolean checaVetorOrdenado(Filme[] filmes);

    Filme buscaLinear_iterativa(Filme[] filmes, int nota) throws Exception;

    Filme buscaLinear_recursiva(Filme[] filmes, int nota) throws Exception;

    Filme buscaBinaria_iterativa(Filme[] filmes, int nota) throws Exception;

    Filme buscaBinaria_recursiva(Filme[] filmes, int nota) throws Exception;

    Filme buscaLinear_iterativa_duasPontas(Filme[] filmes, int nota) throws Exception;

}
