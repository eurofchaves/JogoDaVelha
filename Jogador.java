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
    public Integer geraJogada(List<Integer> jogadasH, List<Integer> jogadasB){
        int decisao = random.nextInt(6);
        
        if(decisao < 4){
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
        } else {

            int possibilidades[] = possibilidades(jogadasH, jogadasB);
            Integer melhorPontuacao = Integer.MIN_VALUE;
            Integer melhorJogada = null;

            for(int jogada : possibilidades){
                jogadasB.add(jogada);
                int pontuacao = minimax(jogadasH, jogadasB, 1);
                jogadasB.remove(jogada);

                if(pontuacao > melhorPontuacao){
                    melhorPontuacao = pontuacao;
                    melhorJogada = jogada;
                }
            }

            return melhorJogada;
        }
    }
    
    public int[] possibilidades(List<Integer> JogadasH, List<Integer> jogadasB){
        int[] possibilidades1 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        Integer[] jogadasH1 = JogadasH.toArray(new Integer[JogadasH.size()]);
        Integer[] jogadasB1 = jogadasB.toArray(new Integer[jogadasB.size()]);
        for(int i=0; i<9 ; i++){
            if(possibilidades1[i] == jogadasH1[i])
            possibilidades1[i] = 0;
            if(possibilidades1[i] == jogadasB1[i])
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
    
    public int minimax(List<Integer> jogadasH, List<Integer> jogadasB, int jogador){
        if (Funcao.checarVencedor(jogadasB, jogadasH) && jogador == 1){
            return 1;
        }
        if (Funcao.checarVencedor(jogadasB, jogadasH) && jogador == 2){
            return -1;
        }
        if (jogadasH.size() == 9 && jogadasB.size() == 9 && !Funcao.checarVencedor(jogadasB, jogadasH)){
            return 0;
        }

        if(jogador == 2){
            int melhorpontuacao = Integer.MIN_VALUE;
            int[] possibilidades = possibilidades(jogadasH, jogadasB);

            for(int possibilidade : possibilidades){
                jogadasB.add(possibilidade);
                int pontuacao = minimax(jogadasH, jogadasB, 1);
                jogadasB.remove(possibilidade);
                melhorpontuacao = Math.max(melhorpontuacao, pontuacao);
            }

            return melhorpontuacao;
        } else {
            int melhorpontuacao = Integer.MAX_VALUE;
            int[] possibilidades = possibilidades(jogadasH, jogadasB);

            for(int possibilidade : possibilidades){
                jogadasH.add(possibilidade);
                int pontuacao = minimax(jogadasH, jogadasB, 2);
                jogadasH.remove(possibilidade);
                melhorpontuacao = Math.min(melhorpontuacao, pontuacao);
            }

            return melhorpontuacao;
        }
    }
}
