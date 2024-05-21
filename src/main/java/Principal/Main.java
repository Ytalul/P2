package Principal;

import Classes.ManipuladorRequisicao;
import Classes.Requisicao;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        // ---- AJUSTAR O CAMINHO DO ARQUIVO NA CLASSE MANIPULADOR LINHA  14 ----
        ManipuladorRequisicao manipulador = new ManipuladorRequisicao();
        List<Requisicao> requisicoes = manipulador.criarListaRequisicao();


        int opcao = 4; // exemplo: calcular a média das requisições
        switch (opcao) {
            case 1:
                manipulador.RecursoGrande(requisicoes);
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                double media = manipulador.MediaReq(requisicoes);
                System.out.println("A média dos tamanhos das requisições POST respondidas com sucesso em 2021 é: " + media);
                break;
            default:
                System.out.println("Opção inválida.");
        }
    }
}
