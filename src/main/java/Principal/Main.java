package Principal;

import Classes.ManipuladorRequisicao;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {

        ManipuladorRequisicao manipulador = new ManipuladorRequisicao();
        //alterar o caminho do arquivo pro caminho que está na sua máquina
        manipulador.criarListaRequisicao("C:\\Users\\ytalo\\Downloads\\access.log");

        int opcaoSelecionada=1;
        Scanner scanner = new Scanner(System.in);
        while ( opcaoSelecionada != 0 ) {
            System.out.println("Selecione uma das opções:\n1 - Recursos grandes respondidos\n2 - Não respondidos\n3 - % de requisições por SO\n4 - Média das requisições POST\n0 - Sair");
            opcaoSelecionada = scanner.nextInt();
            switch (opcaoSelecionada) {
                case 1:
                    // chamar sua função aqui e criá-la na classe Métodos
                case 2: {
                    // chamar sua função aqui e criá-la na classe Métodos
                }
                case 3: {
                    // chamar sua função aqui e criá-la na classe Métodos
                }
                case 4: {
                    // chamar sua função aqui e criá-la na classe Métodos
                }

                // Se ele não selecionar nada, o programa será encerrado
                default: {
                    System.exit(0);

                }
            }
        }
    }
}
