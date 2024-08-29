package interfaces;

import classes.Filme;

import java.util.List;

public interface Busca_IF {
    Filme buscaLinearIterativa(List<Filme> filmes, int nota);
    Filme buscaLinearRecursiva(List<Filme> filmes, int nota);
    Filme buscaBinariaIterativa(Filme[] filmes, int nota);
    Filme buscaBinariaRecursiva(Filme[] filmes, int nota);
}
