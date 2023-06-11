package JogoDaVelha;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        //Define a lista de jogadas dos dois jogadores
        List<Integer> jogadas1 = new ArrayList<>();
        List<Integer> jogadas2 = new ArrayList<>();

        int jogador = 1;

        List<Integer> posicoesEscolhidas = new ArrayList<>();

        Humano j1 = new Humano();
        Humano j2 = new Humano();
        Jogador bot = new Bot();

        int tipoDeJogo;
        do{
            System.out.println("O jogo será entre duas pessoas[1] ou contra bot[2]");
            tipoDeJogo = scanner.nextInt();
        }while(tipoDeJogo != 1 && tipoDeJogo != 2);

        if(tipoDeJogo == 1){
            System.out.println("Insira o nome do Jogador 1: ");
            String nome1 = scanner.next();
            System.out.println("Insira o nome do Jogador 2: ");
            String nome2 = scanner.next();

            j1 = new Humano(nome1, jogadas1);
            j2 = new Humano(nome2, jogadas2);
        }
        else{
            System.out.println("Insira o nome do Jogador 1: ");
            String nome1 = scanner.next();

            j1 = new Humano(nome1, jogadas1);
            bot = new Bot(jogadas2);
        }

        //Cria a figura da tabela
        String[][] tabela = {{"|", "---", "|","---", "|","---", "|"},
                             {"|", "   ", "|", "   ", "|", "   ", "|"},
                             {"|", "---", "|","---", "|","---", "|"},
                             {"|", "   ", "|", "   ", "|", "   ", "|"},
                             {"|", "---", "|","---", "|","---", "|"},
                             {"|", "   ", "|", "   ", "|", "   ", "|"},
                             {"|", "---", "|","---", "|","---", "|"}};

        Funcao.imprimeTabela(tabela);

        int i = 0;
        int j = 0;
        int posicao = 0;
        do {
            do {
                //Recebe a jogada do usuario
                System.out.println("Onde você quer jogar?(1-9) ");
                posicao = scanner.nextInt();

            }while(posicoesEscolhidas.contains(posicao) == true);

            posicoesEscolhidas.add(posicao);

            //Adiciona posição à lista de jogadas do jogador
            if (jogador % 2 == 0) {
                jogadas1.add(posicao);
                i++;
            } else {
                jogadas2.add(posicao);
                j++;
            }

            Funcao.realizaJogada(tabela, posicao, jogador);

            //Altera jogador
            jogador += 1;

            //Altera a tabela e mostra a nova que foi criada
            Funcao.imprimeTabela(tabela);
            System.out.println(jogadas1);
            System.out.println(jogadas2);
        }while(Funcao.checarVencedor(jogadas1, jogadas2) == false && posicoesEscolhidas.size() < 9);

        if(Funcao.checarVencedor(jogadas1, jogadas2) == true){
            if(jogador % 2 == 0){
                System.out.println(j1.nome + " venceu! Que Poggers!");
            }
        }

        if(posicoesEscolhidas.size() == 9 && !Funcao.checarVencedor(jogadas1, jogadas2)){
            System.out.println("not poggers");
        }



        scanner.close();
    }



        
}

