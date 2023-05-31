package JogoDaVelha;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;



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
    public int geraJogada(int[] jogadas){
        boolean numeroRepetido = false;
        int numeroGerado;
        do{
            numeroGerado = random.nextInt(9) + 1;
            for (int jogada : jogadas) {
                if (jogada == numeroGerado) {
                    numeroRepetido = true;
                }
            }
        }while(numeroRepetido == true);

        return numeroGerado;
    }
}