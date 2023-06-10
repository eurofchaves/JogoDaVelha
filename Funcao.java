package JogoDaVelha;

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

    public static boolean checarVencedor(int jogadas1[], int jogadas2[]){
        return false;
    }
}
