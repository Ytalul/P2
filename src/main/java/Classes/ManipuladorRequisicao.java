package Classes;
import java.io.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ManipuladorRequisicao {
    public ArrayList<Requisicao> criarListaRequisicao(String caminhoarquivo) throws IOException {
        ArrayList<Requisicao> listaRequisicao = new ArrayList<Requisicao>();

        try {
            File arquivo = new File(caminhoarquivo);

            FileReader fileReader = new FileReader(arquivo);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            // Posteriormente usar While() pra ler todas as linhas do arquivo
            for (int i = 0; i < 5; i++) {
                Requisicao novaRequisicao = new Requisicao();

                String linha = bufferedReader.readLine();

                String regex = "^(\\S+) \\S+ \\S+ \\[(\\S+ [+-]\\d{4})\\] \"\\S+ (\\S+) \\S+\" (\\d{3}) (\\d+) \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$";
                // Compila a regex em um padrão
                Pattern pattern = Pattern.compile(regex);

                // Cria um matcher para a linha
                Matcher matcher = pattern.matcher(linha);

                // Se encontrar um match, extrai as informações
                if (matcher.find()) {

                    novaRequisicao.enderecoIp = matcher.group(1);
                    novaRequisicao.identidadeCliente = matcher.group(2);
                    novaRequisicao.userId = matcher.group(3);
                    novaRequisicao.data = matcher.group(4);
                    novaRequisicao.tipoRecSolicitacao = matcher.group(5);
                    novaRequisicao.codigoStatus = matcher.group(7);
                    novaRequisicao.tamanhoObjeto = matcher.group(8);

                    // So pra garantir que tá coletando certo
                    System.out.println(novaRequisicao.enderecoIp + novaRequisicao.identidadeCliente + novaRequisicao.userId+ novaRequisicao.data
                    +novaRequisicao.tipoRecSolicitacao+ novaRequisicao.codigoStatus + novaRequisicao.tamanhoObjeto);

                    listaRequisicao.add(novaRequisicao);
                }
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        return listaRequisicao;
    }
}
