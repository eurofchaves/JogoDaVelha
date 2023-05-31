package JogoDaVelha;
import java.util.Scanner;
public class Main {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        int tipoDeJogo;
        do{
            System.out.println("O jogo será entre duas pessoas[1] ou contra bot[2]");
            tipoDeJogo = scanner.nextInt();
        }while(tipoDeJogo != 1 & ipoDeJogo != 2);
        //Define a lista de jogadas dos dois jogadores
        int[] jogadas1 = new int[5];
        int[] jogadas2 = new int[5];

        //Cria a figura da tabela
        String[][] tabela = {{"|", "---", "|","---", "|","---", "|"},
                             {"|", "   ", "|", "   ", "|", "   ", "|"},
                             {"|", "---", "|","---", "|","---", "|"},
                             {"|", "   ", "|", "   ", "|", "   ", "|"},
                             {"|", "---", "|","---", "|","---", "|"},
                             {"|", "   ", "|", "   ", "|", "   ", "|"},
                             {"|", "---", "|","---", "|","---", "|"}};

        Funcao.imprimeTabela(tabela);

        System.out.println("Insira o nome do Jogador 1: ");
        String nome1 = scanner.next();
        System.out.println("Insira o nome do Jogador 2: ");
        String nome2 = scanner.next();



        //Recebe a jogada do usuario
        System.out.println("Onde você quer jogar?(1-9) ");
        int posicao = scanner.nextInt();
        scanner.close();

        int jogador = 1;

    }



        
}

