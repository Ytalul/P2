package Principal;
import Classes.ManipuladorRequisicao;
import Classes.Menu;
import Classes.Requisicao;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        // ---- AJUSTAR O CAMINHO DO ARQUIVO NA CLASSE MANIPULADOR LINHA  14 ----
        ManipuladorRequisicao manipulador = new ManipuladorRequisicao();
        ArrayList<Requisicao> requisicoes = manipulador.criarListaRequisicao();
        Menu menu = new Menu();
        while (true) {
            menu.Opcoes(requisicoes);
        }

    }
}
