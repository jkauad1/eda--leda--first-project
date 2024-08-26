package interfaces;

import classes.Filme;

public interface Busca_IF {
    Filme buscaLinearIterativa(Filme[] filmes, int nota);
    Filme buscaLinearRecursiva(Filme[] filmes, int nota);
    Filme buscaBinariaIterativa(Filme[] filmes, int nota);
    Filme buscaBinariaRecursiva(Filme[] filmes, int nota);
}
