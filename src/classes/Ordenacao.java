package classes;
import java.util.ArrayList;
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

    public void selectionSort(List<Filme> filmes){
        int n = filmes.size();
        for (int i = 0; i < n - 1; i++) {
            int min = i;
            for(int j = i + 1; j < n; j++) {
                if(filmes.get(j).getNota() < filmes.get(min).getNota()) {
                    min = j;
                }
            }
            swap(filmes, i, min);
        }
    }

    public void mergeSort(List<Filme> filmes){
        int n = filmes.size();
        if  (n <= 1){
            return;
        }
        else {
            int mid = filmes.size() / 2;
            List<Filme> left = new ArrayList<>(filmes.subList(0, mid));
            List<Filme> right = new ArrayList<>(filmes.subList(mid, n));

            mergeSort(left);
            mergeSort(right);

            filmes.clear();
            filmes.addAll(merge(left, right));
        }

    }

    private List<Filme> merge(List<Filme> left, List<Filme> right){
        int i = 0, j = 0;
        List<Filme> result = new ArrayList<>();

        while (i < left.size() && j < right.size()){
            if(left.get(i).compareTo(right.get(j)) <= 0){
                result.add(left.get(i++));
            }
            else{
                result.add(right.get(j++));
            }
        }
        while (i < left.size()){
            result.add(left.get(i++));
        }
        while (j < right.size()){
            result.add(right.get(j++));
        }

        return result;
    }

    public void quickSort(List<Filme> filmes, int left, int right) {
        if (left < right) {
            int pivot = partition(filmes, left, right);
            quickSort(filmes, left, pivot - 1);
            quickSort(filmes, pivot + 1, right);
        }
    }

    private int partition(List<Filme> filmes, int left, int right) {
        int pivot = filmes.get(left).getNota();
        int i = left;
        int j = right;

        while (i < j) {

            while (i <= right && filmes.get(i).getNota() >= pivot) {
                i++;
            }
            while (j >= left && filmes.get(j).getNota() < pivot) {
                j--;
            }
            if (i < j) {
                swap(filmes, i, j);
            }
        }
        swap(filmes, left, j);
        return j;
    }
}


