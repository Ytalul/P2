package Principal;

import Classes.ManipuladorRequisicao;
import Classes.Requisicao;
import Classes.Menu;

import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {

        // ---- AJUSTAR O CAMINHO DO ARQUIVO NA CLASSE MANIPULADOR LINHA  14 ----
        ManipuladorRequisicao manipulador = new ManipuladorRequisicao();
        Menu menu = new Menu();
        ArrayList<Requisicao> requisicoes = manipulador.criarListaRequisicao();

        menu.Opcoes(requisicoes);
    }
}
