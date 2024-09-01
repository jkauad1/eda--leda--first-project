package interfaces;

import classes.Filme;

public interface Ordenacao_IF {

    public void bubbleSort(Filme[] filmes);

    public void selectionSort(Filme[] filmes);

    public void insertionSort(Filme[] filmes);

    public void quickSort(Filme[] filmes);

    public void quickSortRandom(Filme[] filmes); // Versão do slide + Shuffle (pivô aleatório)

    public void mergeSort(Filme[] filmes);

    public void countingSort(Filme[] filmes);

}
