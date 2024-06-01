package Principal;

import Classes.ManipuladorRequisicao;
import Classes.Requisicao;
import Classes.Menu;

import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {

        // ---- AJUSTAR O CAMINHO DO ARQUIVO NA CLASSE MANIPULADOR, EM SEU CONSTRUTOR ----
        ManipuladorRequisicao manipulador = new ManipuladorRequisicao();
        ArrayList<Requisicao> requisicoes = manipulador.criarListaRequisicao();
        Menu menu = new Menu();

        menu.Opcoes(requisicoes);
    }
}
