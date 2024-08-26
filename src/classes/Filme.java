package classes;

public class Filme implements Comparable<Filme> {
    private String nome;
    private int nota;
    private int ano;

    public Filme(String nome, int nota, int ano) {
        this.nome = nome;
        this.nota = nota;
        this.ano = ano;
    }

    public String toString(){
        return "Name: " + this.nome + " (" + this.ano + ")" + " Score: " + this.nota;
    }

    @Override
    public int compareTo(Filme m) {
        if (this.nota != m.nota){
            return Integer.compare(m.nota, this.nota);
        }
        else if (this.ano != m.ano) {
            return Long.compare(this.ano, m.ano);
        }
        else {
            return this.nome.compareTo(m.nome);
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }
}
