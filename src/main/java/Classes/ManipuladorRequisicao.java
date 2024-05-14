package Classes;
import java.io.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ManipuladorRequisicao {
    public ArrayList<Requisicao> criarListaRequisicao(String caminhoarquivo) throws IOException {
        ArrayList<Requisicao> listaRequisicao = null;

        try {
            File arquivo = new File(caminhoarquivo);

            FileReader fileReader = new FileReader(arquivo);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            for (int i = 0; i < 5; i++) {
                Requisicao novaRequisicao = new Requisicao();

                String linha = bufferedReader.readLine();

                String regex = "^(\\S+) (\\S+) (\\S+) \\[(.*?)\\] \"(\\S+) ([^\\s]+) (HTTP\\/\\d\\.\\d)\" (\\d+) (\\d+) \"(.*?)\" \"(.*?)\" \"(.*?)\"$";


                // Compila a regex em um padrão
                Pattern pattern = Pattern.compile(regex);

                // Cria um matcher para a linha
                Matcher matcher = pattern.matcher(linha);

                // Se encontrar um match, extrai as informações
                if (matcher.find()) {
                    System.out.println("cheguei aq");
                    novaRequisicao.enderecoIp = matcher.group(1);
                    novaRequisicao.identidadeCliente = matcher.group(2);
                    novaRequisicao.userId = matcher.group(3);
                    novaRequisicao.data = matcher.group(4);
                    novaRequisicao.tipoRecSolicitacao = matcher.group(5);
                    novaRequisicao.codigoStatus = Integer.parseInt(matcher.group(7));
                    novaRequisicao.tamanhoObjeto = Integer.parseInt(matcher.group(8));

                    System.out.println(linha);
                    System.out.println(novaRequisicao.enderecoIp);
                    System.out.println(novaRequisicao.identidadeCliente);
                    System.out.println(novaRequisicao.userId);
                    System.out.println(novaRequisicao.data);
                    System.out.println(novaRequisicao.tipoRecSolicitacao);
                    System.out.println(novaRequisicao.codigoStatus);
                    System.out.println(novaRequisicao.tamanhoObjeto);

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
