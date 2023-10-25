package ProgramaDeRelatorios;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int erro = 0;
        Path caminhoNick = Paths.get("");
        do{
            System.out.println("Qual o nickname do jogador que você deseja buscar?");
            String nick = scanner.next();
            caminhoNick = Paths.get("src/MEDIEVALBATTLE/temp/"+nick+".csv");
            try {
                if (!Files.exists(caminhoNick)) {
                    erro += 1;
                    throw new NoSuchFileException("Esse nickname não existe, tente outro novamente");
                }else{
                    erro = 0;
                }
            } catch (NoSuchFileException ex) {
                System.out.println(ex.getMessage());
            }
        }while(erro!=0);

        List<Relatorio> relatorios = new ArrayList<>();
        List<String> linhasArquivo = Files.readAllLines(caminhoNick);

        for(String linha : linhasArquivo){
            String[] caminho = linha.split(";");
            String data = caminho[0];
            String heroiEscolhido = caminho[1];
            String resultadoPartida = caminho[2];
            String monstroEnfrentado = caminho[3];
            String quantidadeRodadas = caminho[4];

            Relatorio relatorio = new Relatorio(data,heroiEscolhido,resultadoPartida,monstroEnfrentado,quantidadeRodadas);
            relatorios.add(relatorio);
        }

        int rodadas = 0;
        int frequenciaBarbaro = 0;
        int frequenciaPaladino = 0;
        int frequenciaGuerreiro = 0;
        int frequenciaMortoVivo = 0;
        int frequenciaKobold = 0;
        int frequenciaOrc = 0;
        int pontos = 0;
        int frequenciaVitoria = 0;
        int frequenciaDerrota = 0;

        for(Relatorio relatorio : relatorios){
            switch (relatorio.getHeroiEscolhido()) {
                case "Bárbaro" -> frequenciaBarbaro += 1;
                case "Paladino" -> frequenciaPaladino += 1;
                case "Guerreiro" -> frequenciaGuerreiro += 1;
            }
            switch (relatorio.getMonstroEnfrentado()) {
                case "Morto-Vivo" -> frequenciaMortoVivo += 1;
                case "Kobold" -> frequenciaKobold += 1;
                case "Orc" -> frequenciaOrc += 1;
            }
            switch (relatorio.getResultadoPartida()) {
                case "PERDEU" -> frequenciaDerrota += 1;
                case "GANHOU" -> frequenciaVitoria += 1;
            }

            pontos += 100 - Integer.parseInt(relatorio.getQuantidadeRodadas());
            rodadas += Integer.parseInt(relatorio.getQuantidadeRodadas());

        }
        System.out.println();
        String heroiMaisJogado = "";
        if(frequenciaBarbaro > frequenciaPaladino && frequenciaBarbaro > frequenciaGuerreiro){
            heroiMaisJogado = "Bárbaro";
        }
         else if(frequenciaPaladino > frequenciaGuerreiro && frequenciaPaladino > frequenciaBarbaro) {
            heroiMaisJogado = "Paladino";
        }else if(frequenciaGuerreiro > frequenciaBarbaro && frequenciaGuerreiro > frequenciaPaladino) {
            heroiMaisJogado = "Guerreiro";
        }else{
            heroiMaisJogado = "Não possui";
        }
        System.out.println("Herói mais jogado: " + heroiMaisJogado);
        System.out.printf("Monstros Enfrentados: Kobolds %d, Orcs %d, Mortos-Vivos %d \n",frequenciaKobold,frequenciaOrc,frequenciaMortoVivo);
        System.out.println("Pontos Adquiridos: " + pontos);
        System.out.println("Rodadas Jogadas: " + rodadas);
        System.out.printf("Resultado das Partidas: Vitórias - %d, Derrotas - %d \n",frequenciaVitoria,frequenciaDerrota );

    }

}
