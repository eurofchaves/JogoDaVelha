package JogoDaVelha;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Bot extends Jogador{

    private Random random = new Random();
    private String nome = "Bot";

    public Bot(){};
    public Bot(List<Integer> jogadas){
        super(jogadas);
    }

    public String getNome() {
        return this.nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer geraJogada(List<Integer> PosicoesEscolhidas){
        boolean numeroRepetido;
        int numeroGerado;
        do{
            numeroRepetido = false;
            numeroGerado = random.nextInt(9) + 1;
            for (int jogada : PosicoesEscolhidas) {
                if (jogada == numeroGerado) {
                    numeroRepetido = true;
                }
            }
        }while(numeroRepetido);
        System.out.println("numero gerado" + numeroGerado);
        return numeroGerado;
    }
}