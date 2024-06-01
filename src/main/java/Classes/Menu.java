package Classes;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    public void Opcoes(ArrayList<Requisicao> requisicoes){
        ProcessadorDeRelatorios processador = new ProcessadorDeRelatorios();

        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println("Escolha uma das opções: " + "\n1 - Recursos grandes respondidos\n" + "2 - Não respondidos\n" + "3 - % de requisições por SO\n" + "4 - Média das requisições POST\n" + "0 - Sair\n");
            int opcao = scan.nextInt();
            if (opcao == 1) {
                System.out.println("Opção 1 selecionada, gerando arquivo...");
                processador.RecursosGrandes(requisicoes);

            } else if (opcao == 2) {
                System.out.println("Opção 2 selecionada, gerando arquivo...");
                processador.NaoRespondidosNovembro(requisicoes);
            } else if (opcao == 3) {
                System.out.println("Opção 3 selecionada, gerando relatório...");
                processador.RelatorioPorcentagem(requisicoes);

            } else if (opcao == 4) {
                processador.MediaReq(requisicoes);
            }
            else {
                System.out.println("Encerrando o programa.");
                scan.close();
                System.exit(1);
            }
        }
    }
}