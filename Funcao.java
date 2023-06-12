import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class Funcao {

    public static void realizaJogada(String[][] tabela, int posicao, int jogador){
        switch(posicao){
            case 1:
                if(jogador % 2 > 0){
                    tabela[5][1] = " X ";
                } else tabela[5][1] = " O ";
                break;

            case 2:
                if(jogador % 2 > 0){
                    tabela[5][3] = " X ";
                } else tabela[5][3] = " O ";
                break;

            case 3:
                if(jogador % 2 > 0){
                    tabela[5][5] = " X ";
                } else tabela[5][5] = " O ";
                break;

            case 4:
                if(jogador % 2 > 0){
                    tabela[3][1] = " X ";
                } else tabela[3][1] = " O ";
                break;

            case 5:
                if(jogador % 2 > 0){
                    tabela[3][3] = " X ";
                } else tabela[3][3] = " O ";
                break;

            case 6:
                if(jogador % 2 > 0){
                    tabela[3][5] = " X ";
                } else tabela[3][5] = " O ";
                break;

            case 7:
                if(jogador % 2 > 0){
                    tabela[1][1] = " X ";
                } else tabela[1][1] = " O ";
                break;

            case 8:
                if(jogador % 2 > 0){
                    tabela[1][3] = " X ";
                } else tabela[1][3] = " O ";
                break;

            case 9:
                if(jogador % 2 > 0){
                    tabela[1][5] = " X ";
                } else tabela[1][5] = " O ";
                break;
        }
    }

    public static void imprimeTabela(String[][] tabela){
        //Imprime a figura
        for(String[] row: tabela){
            for(String s : row) {
                System.out.print(s);
            }
            System.out.println();
        }
    }

    public static boolean checarVencedor(List<Integer> jogadas1, List<Integer> jogadas2){

        boolean vitoria = false;

        List diagonal1 = Arrays.asList(3, 5, 7);
        List diagonal2 = Arrays.asList(1, 5, 9);
        List horizontal1 = Arrays.asList(7, 8, 9);
        List horizontal2 = Arrays.asList(4, 5, 6);
        List horizontal3 = Arrays.asList(1, 2, 3);
        List vertical1 = Arrays.asList(1, 4, 7);
        List vertical2 = Arrays.asList(2, 5, 8);
        List vertical3 = Arrays.asList(3, 6, 9);

        List<List> listaDeVitorias = new ArrayList<List>();
        listaDeVitorias.add(diagonal1);
        listaDeVitorias.add(diagonal2);
        listaDeVitorias.add(horizontal1);
        listaDeVitorias.add(horizontal2);
        listaDeVitorias.add(horizontal3);
        listaDeVitorias.add(vertical1);
        listaDeVitorias.add(vertical2);
        listaDeVitorias.add(vertical3);

        for(List l : listaDeVitorias){
            if(jogadas1.containsAll(l)){
                vitoria = true;
            }
            if(jogadas2.containsAll(l)){
                vitoria = true;
            }
        }
        return vitoria;
    }
}
