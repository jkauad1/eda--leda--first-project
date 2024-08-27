package classes;

public class Ordenacao {

    public void bubbleSort (int lista[]){
        for (int i = 0; i < lista.length; i++){
            for (int j = 0; j < lista.length - 1; j++){
                if (lista[j] > lista[j + 1]){
                    swap(lista, j, j+1);
                }
            }
        }
    }

    private void swap(int lista[], int a, int b){
        int aux = lista[a];
        lista[a] = lista[b];
        lista[b] = aux;
    }
}
