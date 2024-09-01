package interfaces;

import classes.Filme;

public interface Busca_IF {
    Filme buscaLinear_iterativa(Filme[] filmes, int nota);
    Filme buscaLinear_recursiva(Filme[] filmes, int nota);
    Filme buscaBinaria_iterativa(Filme[] filmes, int nota);
    Filme buscaBinaria_recursiva(Filme[] filmes, int nota);
}
