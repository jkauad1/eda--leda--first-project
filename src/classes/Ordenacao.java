package classes;
import java.util.List;
public class Ordenacao {

    public void bubbleSort (List<Filme> filmes){
        for (int i = 0; i < filmes.size(); i++){
            for (int j = 0; j < filmes.size() - 1; j++){
                if (filmes.get(j).compareTo(filmes.get( j + 1 )) > 0){
                    swap(filmes, j, j+1);
                }
            }
        }
    }

    private void swap(List<Filme> filmes, int a, int b){
        Filme aux = filmes.get(a);
        filmes.set(a, filmes.get(b));
        filmes.set(b, aux);
    }

    public void insertionSort(List<Filme> filmes){
        for (int i = 1; i < filmes.size(); i++){
            Filme key = filmes.get(i);
            int j = i - 1;

            while(j >= 0 && filmes.get(j).compareTo(key) > 0){
                filmes.set(j+1, filmes.get(j));
                j = j - 1;
            }
            filmes.set(j + 1, key);
        }
    }
}
