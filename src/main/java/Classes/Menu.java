package Classes;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    public void Opcoes(ArrayList<Requisicao> requisicoes){
        ManipuladorRequisicao manipulador = new ManipuladorRequisicao();
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println("Escolha uma das opções: " + "\n1 - Recursos grandes respondidos\n" + "2 - Não respondidos\n" + "3 - % de requisições por SO\n" + "4 - Média das requisições POST\n" + "0 - Sair\n");
            int opcao = scan.nextInt();
            if (opcao == 1) {
                System.out.println("Opção 1 selecionada, gerando arquivo...");
                manipulador.RecursoGrande(requisicoes);

            } else if (opcao == 2) {

            } else if (opcao == 3) {
                System.out.println("Opção 3 selecionada, gerando relatório...");
                manipulador.RelatorioPorcentagem(requisicoes);

            } else if (opcao == 4) {
                double media = manipulador.MediaReq(requisicoes);
                System.out.println("A média dos tamanhos das requisições POST respondidas com sucesso em 2021 é: " + media);
            }
            else {
                System.out.println("Encerrando o programa.");
                System.exit(1);
            }
        }
    }
}
