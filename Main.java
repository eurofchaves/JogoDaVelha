package JogoDaVelha;
import java.util.Scanner;
public class Main {
    public static void main(String[] args){

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

        Scanner scanner = new Scanner(System.in);
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

