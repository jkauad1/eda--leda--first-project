package classes;

import interfaces.Filme_IF;

import java.util.concurrent.ThreadLocalRandom;

public class Filme implements Filme_IF {

    private String nome;
    private int nota;
    private int ano;

    private static final String[] Titulos = {"Era do Gelo: ", "Piratas do Caribe: ", "Rei Leão: ", "Velozes e Furiosos: ", "Mad Max: ", "O Vendedor de Linguiça: ", "Os Vingadores: ", "Tropa de Elite: ", "Cidade de Deus: ", "JheffersonKauã: ", "Transformers: ", "Ratatouille: ", "Pitú: ", "Os Trapalhões: ", "Os Minions: ", "Herbie: ","Os cara de pau: " };
    private static final String[] SubTitulos = {"A História de uma abelha", "A era de ultron", "A vingança dos derrotados", "O lado escuro da lua", "Desafio na UEPB", "uma noite muito louca", "Sexo com Proteção", "Prisioneiro de Azkaban", "Câmara Secreta", "A Pedra Filosofal", "Trair é errado", "Meu fusca turbinado" , "e os 7 anões", "Guerra infinita"};

    public Filme(String nome, int nota, int ano) {
        this.nome = nome;
        this.nota = nota;
        this.ano = ano;
    }

    public Filme(){
        ThreadLocalRandom rand = ThreadLocalRandom.current();

        this.nome = Titulos[rand.nextInt(Titulos.length)] + SubTitulos[rand.nextInt(SubTitulos.length)];
        this.ano = rand.nextInt(1980, 2025); // Gera um ano aleatório entre 1980 e 2024
        this.nota = rand.nextInt(1, 6); // Gera uma nota aleatória entre 1 e 5 (inclusive)
    }

    @Override
    public String toString(){
        return "Nome: " + this.nome + " (" + this.ano + ")" + " Nota: " + this.nota;
    }

    @Override
    public int compareTo(Filme_IF outro_Filme) {
        if (this.nota != outro_Filme.getNota()){
            return Integer.compare(outro_Filme.getNota(), this.nota);
        }
        else if (this.ano != outro_Filme.getAno()) {
            return Long.compare(this.ano, outro_Filme.getAno());
        }
        else {
            return this.nome.compareTo(outro_Filme.getNome());
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