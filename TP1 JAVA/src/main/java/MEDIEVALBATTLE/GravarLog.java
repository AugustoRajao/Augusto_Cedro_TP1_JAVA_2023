package MEDIEVALBATTLE;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class GravarLog {
    public static void gravarLog(String nickName,String log) throws IOException {
        //CRIANDO DIRETORIO
        String diretorioTemp = "src/main/java/MEDIEVALBATTLE/temp";
        File diretorio = new File(diretorioTemp);

        if (!diretorio.exists()) {
            Files.createDirectory(Paths.get(diretorioTemp));
        }
        //CRIANDO O CSV DO NICK
        Path nicknameFilePath = Paths.get(diretorioTemp +"/"+ nickName + ".csv");
        File caminhoCSV = new File(String.valueOf(nicknameFilePath));
        if (!caminhoCSV.exists()) {
            Files.createFile(nicknameFilePath);
        }
        //ESCREVENDO NO ARQUVIO
        List<String> linhasArquivo = Files.readAllLines(nicknameFilePath);
        linhasArquivo.add(log);
        Files.write(nicknameFilePath,linhasArquivo);
    }
}
