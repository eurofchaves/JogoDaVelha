import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        //Define a lista de jogadas dos dois jogadores
        List<Integer> jogadas1 = new ArrayList<>();
        List<Integer> jogadas2 = new ArrayList<>();
        List<Integer> posicoesEscolhidas = new ArrayList<>();

        int jogador = 1;
        boolean x;

        Humano j1 = new Humano();
        Humano j2 = new Humano();
        Bot bot = new Bot();

        //Cria a figura da tabela
        String[][] tabela = {{"|", "---", "|","---", "|","---", "|"},
                             {"|", "   ", "|", "   ", "|", "   ", "|"},
                             {"|", "---", "|","---", "|","---", "|"},
                             {"|", "   ", "|", "   ", "|", "   ", "|"},
                             {"|", "---", "|","---", "|","---", "|"},
                             {"|", "   ", "|", "   ", "|", "   ", "|"},
                             {"|", "---", "|","---", "|","---", "|"}};
        
        int tipoDeJogo;

        do{
            System.out.println("O jogo será entre duas pessoas[1] ou contra bot[2]");
            tipoDeJogo = scanner.nextInt();
        }while(tipoDeJogo != 1 && tipoDeJogo != 2);

        if(tipoDeJogo == 1){
            System.out.println("Insira o nome do Jogador 1: ");
            String nome1 = scanner.next();
            j1.setNome(nome1);
            j1.setJogadas(jogadas1);
            System.out.println("Insira o nome do Jogador 2: ");
            String nome2 = scanner.next();
            j2.setNome(nome2);
            j2.setJogadas(jogadas2);
        }
        else{
            System.out.println("Insira o nome do Jogador 1: ");
            String nome1 = scanner.next();
            j1.setNome(nome1);
            j1.setJogadas(jogadas1);
            bot.setJogadas(jogadas2);
        }

        Funcao.imprimeTabela(tabela);

        int posicao = 0;
        if(tipoDeJogo == 1){
            do {
                do {
                    //Recebe a jogada do usuario
                    System.out.print("Onde você quer jogar?(1-9):  ");
                    posicao = scanner.nextInt();

                }while(posicoesEscolhidas.contains(posicao) == true);

                posicoesEscolhidas.add(posicao);
                //Adiciona posição à lista de jogadas do jogador
                if (jogador % 2 == 0) {
                    j1.addJogada(posicao);
                } else {
                    j2.addJogada(posicao);
                }

                Funcao.realizaJogada(tabela, posicao, jogador);

                //Altera jogador
                jogador += 1;

                //Altera a tabela e mostra a nova que foi criada
                Funcao.imprimeTabela(tabela);
            }while(!Funcao.checarVencedor(j1.getJogadas(), j2.getJogadas()) && posicoesEscolhidas.size() < 9);

            if(Funcao.checarVencedor(j1.getJogadas(), j2.getJogadas())){
                if(jogador % 2 == 0){
                    System.out.println(j1.getNome() + " venceu! Que Poggers!");
                } else {
                    System.out.println(j2.getNome() + " venceu! Que Poggers!");
                }
            }

            if(posicoesEscolhidas.size() == 9 && Funcao.checarVencedor(j1.getJogadas(), j2.getJogadas())){
                System.out.println("not poggers");
            }
        } else {
            do {
                //Recebe a jogada do usuario
                System.out.print("Onde você quer jogar?(1-9):  ");
                posicao = scanner.nextInt();

            }while(posicoesEscolhidas.contains(posicao) == true);
            
            posicoesEscolhidas.add(posicao);

            if(!Funcao.checarVencedor(j1.getJogadas(), bot.getJogadas())){

            }
        }

        scanner.close();
    }     
}
