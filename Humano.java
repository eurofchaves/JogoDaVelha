package JogoDaVelha;

import java.util.List;

public class Humano extends Jogador {
    
    private String nome;

    public Humano() {}
    public Humano (String nome, List<Integer> jogadas){
        super(jogadas);
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

}