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

        criaTabela(tabela);


    }

    public static void criaTabela(String[][] tabela){
        //Imprime a figura
        for(String[] row: tabela){
            for(String s : row) {
                System.out.print(s);
            }
            System.out.println();
    }

}
}
