package Principal;

import Classes.ManipuladorRequisicao;

import java.io.IOException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {
        int idade = 150;

        ManipuladorRequisicao manipulador = new ManipuladorRequisicao();
        //alterar o caminho do arquivo pro caminho que está na sua máquina
        manipulador.criarListaRequisicao("C:\\Users\\71109791488\\Downloads\\access.log");

    }
}
