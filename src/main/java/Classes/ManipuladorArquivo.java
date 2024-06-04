package Classes;

import java.io.*;

public class ManipuladorArquivo {

    private File arquivo;
    private FileReader fileReader;
    private BufferedReader bufferedReader;
    private FileWriter fileWriter;
    private BufferedWriter bufferedWriter;

    public ManipuladorArquivo() {
        try {
            arquivo = new File("C:\\Users\\AzupixLS\\Downloads\\access.log");
            fileReader = new FileReader(arquivo);
            bufferedReader = new BufferedReader(fileReader);
        } catch (FileNotFoundException e) {
            System.out.println("O arquivo não foi encontrado para leitura");
            e.printStackTrace();
        }
    }

    public String lerArquivo() {
        try {
            return bufferedReader.readLine();
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    public void fecharArquivo() {
        try {
            if (bufferedReader != null) bufferedReader.close();
        } catch (IOException e) {
            System.out.println("Erro ao fechar o arquivo: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void abrirArquivoParaEscrita(String caminhoArquivo) {
        try {
            arquivo = new File(caminhoArquivo);
            fileWriter = new FileWriter(arquivo);
            bufferedWriter = new BufferedWriter(fileWriter);
        } catch (IOException e) {
            System.out.println("Erro ao abrir o arquivo para escrita: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void escreverNoArquivo(String conteudo) {
        try {
            if (bufferedWriter != null) {
                bufferedWriter.write(conteudo);
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao escrever no arquivo: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void fecharArquivoEscrita() {
        try {
            if (bufferedWriter != null) bufferedWriter.close();
        } catch (IOException e) {
            System.out.println("Erro ao fechar o arquivo: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
