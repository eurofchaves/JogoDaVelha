package JogoDaVelha;
import java.util.ArrayList;
import java.util.Random;
import java.util.List;

public abstract class Jogador {
    protected List<Integer> jogadas = new ArrayList<>();
}

class Humano extends Jogador{
    public String nome;
    public Humano(){};
    public Humano(String nome, List<Integer> jogadas){
        this.nome = nome;
        this.jogadas = jogadas;
    }
}

class Bot extends Jogador{
    private Random random = new Random();
    Bot(){};
    Bot(List<Integer> jogadas){
        this.jogadas = jogadas;
    }
    public Integer geraJogada(List<Integer> jogadasH, List<Integer> jogadasB){
        boolean numeroRepetido = false;
        int numeroGerado;
        do{
            numeroGerado = random.nextInt(9) + 1;
            for (int jogada : jogadas) {
                if (jogada == numeroGerado) {
                    numeroRepetido = true;
                }
            }
        }while(numeroRepetido);
    
        return numeroGerado;
    }
}
