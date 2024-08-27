package classes;

import java.util.Random;

public class Filme implements Comparable<Filme> {
    private String nome;
    private int nota;
    private int ano;
    public static Random rand = new Random();

    private static String[] Titulos = {"Era do Gelo: ", "Piratas do Caribe: ", "Rei Leão: ", "Velozes e Furiosos: ", "Mad Max: ", "O Vendedor de Linguiça: ", "Os Vingadores: ", "Tropa de Elite:", "Cidade de Deus: ", "JheffersonKauã: ", "Transformers: ", "Ratatuile: ", "Pitú: "};
    private static String[] SubTitulos = {"A História de uma abelha", "A era de ultron", "A vingança dos derrotados", "O lado escuro da lua", "Desafio na UEPB", "uma noite muito louca", "Sexo com Proteção", "Prisioneiro de Azkaban", "Câmara Secreta", "A Pedra Filosofal", "Trair é errado"};
    public Filme(String nome, int nota, int ano) {
        this.nome = nome;
        this.nota = nota;
        this.ano = ano;
    }

    public Filme(){
        this.nome = Titulos[rand.nextInt(Titulos.length)] + SubTitulos[rand.nextInt(SubTitulos.length)];
        this.ano = rand.nextInt(1980, 2025);
        this.nota = rand.nextInt(1,5);
    }

    public String toString(){
        return "\nNome: " + this.nome + " (" + this.ano + ")" + " Nota: " + this.nota;
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
