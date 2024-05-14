package Principal;

import Classes.ManipuladorRequisicao;

import java.io.IOException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Hello world only;");
        ManipuladorRequisicao manipulador = new ManipuladorRequisicao();
        manipulador.criarListaRequisicao("C:\\Users\\ytalo\\Downloads\\access.log");
    }
}
