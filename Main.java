package JogoDaVelha;
import java.util.Scanner;
import java.util.Random;
public class Main {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        //Define a lista de jogadas dos dois jogadores
        int[] jogadas1 = new int[5];
        int[] jogadas2 = new int[5];

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

            Jogador j1 = new Humano(nome1, jogadas1);
            Jogador j2 = new Humano(nome2, jogadas2);
        }
        else{
            System.out.println("Insira o nome do Jogador 1: ");
            String nome1 = scanner.next();

            Jogador j1 = new Humano(nome1, jogadas1);
            Jogador bot = new Bot(jogadas2);
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




        //Recebe a jogada do usuario
        System.out.println("Onde você quer jogar?(1-9) ");
        int posicao = scanner.nextInt();
        scanner.close();

        int jogador = 1;

    }



        
}

