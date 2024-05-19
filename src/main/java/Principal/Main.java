package Principal;

import Classes.ManipuladorRequisicao;
import Classes.Requisicao;
import Interfaces.iMetodos;
import Classes.Metodos;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        String filePath = "C:\\Users\\AzupixLS\\Downloads\\access.log"; // ajuste o caminho do arquivo
        ManipuladorRequisicao manipulador = new ManipuladorRequisicao();
        List<Requisicao> requisicoes = manipulador.criarListaRequisicao(filePath);

        iMetodos metodos = new Metodos();

        // Supondo que temos um menu de opções
        int opcao = 4; // exemplo: calcular a média das requisições

        switch (opcao) {
            case 1:
                // Chamar método para "Recurso grande"
                break;
            case 2:
                // Chamar método para "Não respondido"
                break;
            case 3:
                // Chamar método para "Das requisições"
                break;
            case 4:
                // Chamar método para calcular a média das requisições
                double media = metodos.MediaReq(requisicoes);
                System.out.println("A média dos tamanhos das requisições POST respondidas com sucesso em 2021 é: " + media);
                break;
            default:
                System.out.println("Opção inválida.");
        }
    }
}
