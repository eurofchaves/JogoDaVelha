package JogoDaVelha;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static Scanner scanner;
    private static List<Integer> jogadas1;
    private static List<Integer> jogadas2;
    private static List<Integer> posicoesEscolhidas;
    private static int jogador;
    private static Humano j1;
    private static Humano j2;
    private static Bot bot;
    private static String[][] tabela;
    private static int tipoDeJogo;

    public static void main(String[] args) {
        int continuar = 0;
        boolean x;
        do{
            scanner = new Scanner(System.in);
            jogadas1 = new ArrayList<>();
            jogadas2 = new ArrayList<>();
            posicoesEscolhidas = new ArrayList<>();
            jogador = 1;
            j1 = new Humano();
            j2 = new Humano();
            bot = new Bot();

            tabela = new String[][]{{"|", "---", "|", "---", "|", "---", "|"},
                    {"|", "   ", "|", "   ", "|", "   ", "|"},
                    {"|", "---", "|", "---", "|", "---", "|"},
                    {"|", "   ", "|", "   ", "|", "   ", "|"},
                    {"|", "---", "|", "---", "|", "---", "|"},
                    {"|", "   ", "|", "   ", "|", "   ", "|"},
                    {"|", "---", "|", "---", "|", "---", "|"}};

            escolherTipoDeJogo();
            Funcao.imprimeTabela(tabela);

            if (tipoDeJogo == 1) {
                jogarModoPessoa();
            } else {
                jogarModoBot();
            }
            do{
                x = false;
                try {
                    System.out.println("Você deseja continuar jogando? [1] para continuar, [0] pra sair");
                    continuar = scanner.nextInt();
                } catch (java.util.InputMismatchException e) {
                    System.out.println("\n-----------Por favor, Digite somente números.-----------\n");
                    x = true;
                    scanner.nextLine();
                }
                if(continuar!=0 && continuar!=1){
                    System.out.println("\n-----------Por favor, Digite somente 0 ou 1.-----------\n");
                    x = true;
                }
            }while(x);
        }while(continuar == 1);
        scanner.close();
    }

    private static void escolherTipoDeJogo() {
        do {
            try{
                System.out.println("O jogo será entre duas pessoas[1] ou contra bot[2]");
                tipoDeJogo = scanner.nextInt();
                if(tipoDeJogo != 1 && tipoDeJogo != 2){
                    System.out.println("\n-----------Por favor, Digite 1 ou 2.-----------\n");
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("\n-----------Por favor, Digite um número inteiro.-----------\n");
                tipoDeJogo = 0;
                scanner.nextLine();
            }
        } while (tipoDeJogo != 1 && tipoDeJogo != 2);

        System.out.println("Insira o nome do Jogador 1: ");
        String nome1 = scanner.next();
        j1.setNome(nome1);
        j1.setJogadas(jogadas1);

        if (tipoDeJogo == 1) {
            System.out.println("Insira o nome do Jogador 2: ");
            String nome2 = scanner.next();
            j2.setNome(nome2);
            j2.setJogadas(jogadas2);
        } else {
            bot.setJogadas(jogadas2);
        }
    }

    private static void jogarModoPessoa() {
        int posicao = 0;
        boolean x;
        do {
            do {
                try{
                    x = false;
                    System.out.print("Onde você quer jogar?(1-9):  ");
                    posicao = scanner.nextInt();
                    if(posicoesEscolhidas.contains(posicao)){
                        System.out.println("\n-----------Posição já escolhida. Por favor, Digite outra posição.-----------\n");
                    }
                    if(posicao>9 || posicao<1){
                        System.out.println("\n-----------Por favor, Digite um número de 1 à 9.-----------\n");
                        x = true;
                    }
                } catch (java.util.InputMismatchException e) {
                    System.out.println("\n-----------Por favor, Digite um número inteiro.-----------\n");
                    x = true;
                    scanner.nextLine();
                }
            } while (posicoesEscolhidas.contains(posicao) || x);

            posicoesEscolhidas.add(posicao);

            if (jogador % 2 == 1) {
                j1.addJogada(posicao);
            } else {
                j2.addJogada(posicao);
            }

            Funcao.realizaJogada(tabela, posicao, jogador);

            jogador++;
            Funcao.imprimeTabela(tabela);

        } while (!Funcao.checarVencedor(j1.getJogadas(), j2.getJogadas(), null, null) && posicoesEscolhidas.size() < 9);

        Funcao.checarVencedor(j1.getJogadas(), j2.getJogadas(), j1.getNome(), j2.getNome());

        if (posicoesEscolhidas.size() == 9 && !Funcao.checarVencedor(j1.getJogadas(), j2.getJogadas(), null, null)) {
            System.out.println("not poggers");
        }
    }

    private static void jogarModoBot() {
        int posicao = 0;
        boolean x;
        do{
            do {
                try{
                    x = false;
                    System.out.print("Onde você quer jogar?(1-9):  ");
                    posicao = scanner.nextInt();
                    if(posicoesEscolhidas.contains(posicao)){
                        System.out.println("\n-----------Posição já escolhida. Por favor, Digite outra posição.-----------\n");
                    }
                    if(posicao>9 || posicao<1){
                        System.out.println("\n-----------Por favor, Digite um número de 1 à 9.-----------\n");
                        x = true;
                    }
                } catch (java.util.InputMismatchException e) {
                    System.out.println("\n-----------Por favor, Digite um número inteiro.-----------\n");
                    x = true;
                    scanner.nextLine();
                }
            } while (posicoesEscolhidas.contains(posicao) || x);
            posicoesEscolhidas.add(posicao);
            j1.addJogada(posicao);

            Funcao.realizaJogada(tabela, posicao, jogador);

            Funcao.imprimeTabela(tabela);

            jogador++;
            if(posicoesEscolhidas.size() != 9 && !Funcao.checarVencedor(j1.getJogadas(), bot.getJogadas(), null, null)){
                int jogadaDoBot = bot.geraJogada(posicoesEscolhidas);

                posicoesEscolhidas.add(jogadaDoBot);
                bot.addJogada(jogadaDoBot);

                Funcao.realizaJogada(tabela, jogadaDoBot, jogador);

                Funcao.imprimeTabela(tabela);
                jogador++;
            }

        }while(!Funcao.checarVencedor(j1.getJogadas(), bot.getJogadas(), null, null) && posicoesEscolhidas.size() < 9);

        Funcao.checarVencedor(j1.getJogadas(), bot.getJogadas(), j1.getNome(), bot.getNome());

        if (posicoesEscolhidas.size() == 9 && !Funcao.checarVencedor(j1.getJogadas(), bot.getJogadas(), null, null)) {
            System.out.println("EMPATOU");
        }

        }
    }
