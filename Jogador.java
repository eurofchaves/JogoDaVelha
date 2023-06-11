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
    private Random random;
    Bot(){};
    Bot(List<Integer> jogadas){
        this.jogadas = jogadas;
    }
    public Integer geraJogada(int[] jogadasH, int[] JogadasB){
        /*boolean numeroRepetido = false;
        int numeroGerado;
        do{
            numeroGerado = random.nextInt(9) + 1;
            for (int jogada : jogadas) {
                if (jogada == numeroGerado) {
                    numeroRepetido = true;
                }
            }
        }while(numeroRepetido == true);

        return numeroGerado;*/

        int possibilidades[] = possibilidades(jogadasH, JogadasB);
        Integer melhorMovimento = null;


        return melhorMovimento;
    }

    public int[] possibilidades(int[] JogadasH, int[] JogadasB){
        int[] possibilidades1 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        for(int i=0; i<9 ; i++){
            if(possibilidades1[i] == JogadasH[i])
            possibilidades1[i] = 0;
            if(possibilidades1[i] == JogadasB[i])
            possibilidades1[i] = 0;
        }
        int a = 0;
        for(int possiveis : possibilidades1){
            if(possiveis != 0){
                a++;
            }
        }
        int possibilidades2[] = new int[a];
        for(int i=0; i<a; i++){
            if(possibilidades1[i] != 0){
                possibilidades2[i] = possibilidades1[i];
            }
        }
        return possibilidades2;
    }

}
