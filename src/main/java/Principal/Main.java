package Principal;

import Classes.ManipuladorRequisicao;
import Classes.Requisicao;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        // ---- AJUSTAR O CAMINHO DO ARQUIVO NA CLASSE MANIPULADOR LINHA  14 ----
        ManipuladorRequisicao manipulador = new ManipuladorRequisicao();
        List<Requisicao> requisicoes = manipulador.criarListaRequisicao();


        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println("Escolha uma das opções: " +
                    "\n1 - Recursos grandes respondidos\n" +
                    "2 - Não respondidos\n" +
                    "3 - % de requisições por SO\n" +
                    "4 - Média das requisições POST\n" +
                    "0 - Sair\n");
            int opcao = scan.nextInt();
            if (opcao == 1) {
                System.out.println("Opção 1 selecionada, gerando arquivo...");
                manipulador.RecursoGrande(requisicoes);
                System.out.println("Arquivo criado!");
            } else if (opcao == 2) {

            } else if (opcao == 3) {
                System.out.println("Opção 3 selecionada, gerando relatório...");
                manipulador.RelatorioPorcentagem(requisicoes);
                System.out.println("Relatório criado!");
            } else if (opcao == 4) {
                double media = manipulador.MediaReq(requisicoes);
                System.out.println("A média dos tamanhos das requisições POST respondidas com sucesso em 2021 é: " + media);
            }
            else {
                System.out.println("Encerrando o programa.");
                break;
            }
        }

    }
}
