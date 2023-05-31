package JogoDaVelha;
import java.util.Scanner;
public class JogoDaVelha {
    public static void main(String[] args){

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
        Scanner scanner = new Scanner(System.in);
        System.out.println("Onde você quer jogar?(1-9) ");
        int posicao = scanner.nextInt();
        scanner.close();

        int jogador = 1;

        Funcao.realizaJogada(tabela, posicao, jogador);

        Funcao.imprimeTabela(tabela);
    }



        
}

