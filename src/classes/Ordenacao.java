package classes;
import interfaces.Ordenacao_IF;

public class Ordenacao implements Ordenacao_IF {

    @Override
    public void bubbleSort (Filme[] filmes){
        for (int i = 0; i < filmes.length; i++){
            for (int j = 0; j < filmes.length - 1; j++){
                if (filmes[j].compareTo(filmes[j + 1]) > 0){
                    swap(filmes, j, j+1);
                }
            }
        }
    }

    private void swap(Filme[] filmes, int a, int b){
        Filme aux = filmes[a];
        filmes[a] = filmes[b];
        filmes[b] = aux;
    }
    @Override
    public void insertionSort(Filme[] filmes){
        for (int i = 1; i < filmes.length; i++){
            Filme key = filmes[i];
            int j = i - 1;

            while(j >= 0 && filmes[j].compareTo(key) > 0){
                filmes[j+1] = filmes[j];
                j = j - 1;
            }
            filmes[j + 1] = key;
        }
    }
    @Override
    public void selectionSort(Filme[] filmes){
        int n = filmes.length;
        for (int i = 0; i < n - 1; i++) {
            int max = i;
            for(int j = i + 1; j < n; j++) {
                if(filmes[j].compareTo(filmes[max]) < 0) {
                    max = j;
                }
            }
            swap(filmes, i, max);
        }
    }
    @Override
    public void mergeSort(Filme[] filmes){
        int n = filmes.length;
        if  (n <= 1){
            return;
        }
        else {
            int mid = n / 2;
            Filme[] left = new Filme[mid];
            Filme[] right = new Filme[n - mid];

            System.arraycopy(filmes, 0, left, 0, mid);
            System.arraycopy(filmes, mid, right, 0, n - mid);

            mergeSort(left);
            mergeSort(right);

            merge(filmes, left, right);
        }

    }

    private void merge(Filme[] filmes, Filme[] left, Filme[] right){
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length){
            if(left[i].compareTo(right[j]) <= 0){
                filmes[k++] = left[i++];
            }
            else{
                filmes[k++] = right[j++];
            }
        }
        while (i < left.length){
            filmes[k++] = left[i++];
        }
        while (j < right.length){
            filmes[k++] = right[j++];
        }
    }
    @Override
    public void quickSort(Filme[] filmes){
        quickSort(filmes, 0, filmes.length - 1);
    }

    public void quickSort(Filme[] filmes, int left, int right) {

        if (left < right) {
            int pivot = partition(filmes, left, right);
            quickSort(filmes, left, pivot - 1);
            quickSort(filmes, pivot + 1, right);
        }
    }

    @Override
    public void quickSortRandom(Filme[] filmes){

    }

    private int partition(Filme[] filmes, int left, int right) {
        int pivot = filmes[left].getNota();
        int i = left;
        int j = right;

        while (i < j) {

            while (i <= right && filmes[i].getNota() >= pivot) {
                i++;
            }
            while (j >= left && filmes[j].getNota() < pivot) {
                j--;
            }
            if (i < j) {
                swap(filmes, i, j);
            }
        }
        swap(filmes, left, j);
        return j;
    }

    @Override
    public void countingSort(Filme[] filmes) {
        int maximo = 5;

        int[] listaAuxiliar = new int[maximo + 1];
        Filme[] filmesCopia = filmes.clone();

        for (Filme filme : filmes) {
            listaAuxiliar[filme.getNota()]++;
        }

        for (int i = listaAuxiliar.length - 2; i >= 0; i--) {
            listaAuxiliar[i] += listaAuxiliar[i + 1];
        }

        for (int j = filmesCopia.length - 1; j >= 0; j--) {
            int nota = filmesCopia[j].getNota();
            filmes[listaAuxiliar[nota] - 1] = filmesCopia[j];
            listaAuxiliar[nota]--;
        }
    }
}



