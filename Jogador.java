package JogoDaVelha;

import java.util.ArrayList;
import java.util.List;

public abstract class Jogador{

    private List<Integer> jogadas = new ArrayList<>();

    public Jogador() {}
    public Jogador(List<Integer> jogadas) {
        this.jogadas = jogadas;
    }

    public List<Integer> getJogadas() {
        return this.jogadas;
    }
    public void setJogadas(List<Integer> jogadas) {
        this.jogadas = jogadas;
    }
    
    public void addJogada(int jogada) {
        jogadas.add(jogada);
    }
}
