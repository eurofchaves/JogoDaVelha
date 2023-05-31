package JogoDaVelha;
import java.util.Random;




public class Jogador {
    protected int[] jogadas = new int[5];

}

class Humano extends Jogador{
    String nome;
    Humano(String nome, int[] jogadas){
        this.nome = nome;
        this.jogadas = jogadas;
    }
}

class Bot extends Jogador{
    private Random random;
    Bot(Random random, int[] jogadas){
        this.random = random;
        this.jogadas = jogadas;
    }
    public int geraJogada(){
        int numeroGerado = random.nextInt(9) + 1;
        return random.nextInt(9) + 1;
    }
}