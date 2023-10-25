package MEDIEVALBATTLE;

import MEDIEVALBATTLE.Metodos.Metodos;
import MEDIEVALBATTLE.Personagens.Herois.Barbaro;
import MEDIEVALBATTLE.Personagens.Herois.Guerreiro;
import MEDIEVALBATTLE.Personagens.Herois.Paladino;
import MEDIEVALBATTLE.Personagens.IPersonagem;
import MEDIEVALBATTLE.Personagens.Player;

import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.file.*;
import java.time.LocalDate;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Metodos gerador = new Metodos();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bem Vindo(a) ao Medieval Battle");
        System.out.println("===============================");
        System.out.println("Digite seu nickname:");
        String nickName = scanner.next();
        System.out.println("Escolha qual classe você quer:");

        Paladino paladinoStatus = new Paladino();
        Barbaro barbaroStatus = new Barbaro();
        Guerreiro guerreiroStatus = new Guerreiro();

        System.out.println(paladinoStatus.toString());
        System.out.println(barbaroStatus.toString());
        System.out.println(guerreiroStatus.toString());
        int invalido = 0;
        int heroi = 0;
            do {
                invalido = 0;
                String classe = scanner.next().toLowerCase();
                switch (classe) {
                    case "paladino":
                        System.out.println("Você escolheu o Paladino");
                        heroi = 0;
                        break;
                    case "barbaro":
                        System.out.println("Você escolheu o Bárbaro");
                        heroi = 1;
                        break;
                    case "guerreiro":
                        System.out.println("Você escolheu o Guerreiro");
                        heroi = 2;
                        break;
                    default:
                        invalido++;
                        System.out.println("Personagem inválido, tente novamente");
                }
            } while (invalido == 1);
        Paladino paladino = new Paladino();
        Barbaro barbaro = new Barbaro();
        Guerreiro guerreiro = new Guerreiro();

        IPersonagem[] herois = new IPersonagem[3];
        herois[0] = paladino;
        herois[1] = barbaro;
        herois[2] = guerreiro;

        Player jogador = new Player(nickName, herois[heroi]);
        System.out.println(jogador.toString());

        System.out.println("Começando o Medieval Battle...");
        int rodadas = 1;
        int heroiVida = herois[heroi].Vida();
        String resultado = null;
            IPersonagem inimigo = gerador.GerarInimigo();
            int monstroVida = inimigo.Vida();
            System.out.println("Um " + inimigo.Nome() + " Apareceu");
            do {
                System.out.println("===============================");
                System.out.println("FASE DE INICIAÇÃO");
                System.out.println("===============================");
                System.out.println();
                System.out.println("Rodada: " + rodadas);
                System.out.println();
                System.out.println("Calculando iniciativa...");
                int iniciativaHeroi = 0;
                int iniciativaMonstro = 0;
                do {
                    iniciativaHeroi = gerador.CalculadoraIniciativa(herois[heroi].Agilidade());
                    iniciativaMonstro = gerador.CalculadoraIniciativa(inimigo.Agilidade());
                } while (iniciativaHeroi ==  iniciativaMonstro);

                System.out.println("Sua agilidade: " + iniciativaHeroi);
                System.out.println("Agilidade do " + inimigo.Nome() + ": " + iniciativaMonstro);

                System.out.println("===============================");
                System.out.println("FASE DE ATAQUES");
                System.out.println("===============================");
                System.out.println();

                int defesaMonstro = 0;
                int ataqueHeroi = 0;
                int ataqueMonstro = 0;
                int defesaHeroi = 0;

                if (iniciativaHeroi > iniciativaMonstro) {

                    System.out.println("Você começa Atacando.");
                    System.out.println();
                    System.out.println("Rolando Ataque...");

                    ataqueHeroi = gerador.CalculadoraAtaque(herois[heroi].Agilidade(),herois[heroi].Forca());
                    System.out.println();
                    System.out.println("Seu ATAQUE: " + ataqueHeroi);

                    defesaMonstro = gerador.CalcularDefesa(inimigo.Agilidade(),inimigo.Defesa());
                    System.out.println("Defesa do " + inimigo.Nome() + ": " + defesaMonstro);
                    System.out.println();

                    if (ataqueHeroi <= defesaMonstro) {
                        System.out.println("A Defesa GANHOU, Recomeçando a Rodada de Ataque...");
                    } else {
                        System.out.println("Seu ATAQUE GANHOU, Calculando DANO...");

                        int danoHeroi = gerador.CalcularDano(herois[heroi].FatorDeDano(),herois[heroi].Forca());
                        System.out.println("Seu DANO:" + danoHeroi);

                        monstroVida = monstroVida - danoHeroi;
                        System.out.println("Vida do " + inimigo.Nome() + ": " + monstroVida + " Pontos de vida");
                    }
                } else {
                    System.out.println("O " + inimigo.Nome() + " começara Atacando.");
                    System.out.println();
                    System.out.println("Rolando Ataque...");

                    defesaHeroi = gerador.CalcularDefesa(herois[heroi].Agilidade(),herois[heroi].Defesa());
                    System.out.println();
                    System.out.println("Sua DEFESA: " + defesaHeroi);

                    ataqueMonstro = gerador.CalculadoraAtaque(inimigo.Agilidade(),inimigo.Forca());
                    System.out.println("ATAQUE do " + inimigo.Nome() + ": " + ataqueMonstro);

                    System.out.println();

                    if (ataqueMonstro <= defesaHeroi) {
                        System.out.println("Sua Defesa GANHOU, Recomeçando a Rodada de Ataque...");
                    } else {
                        System.out.println("Sua Defesa PERDEU, Calculando DANO...");
                        System.out.println();
                        int danoMonstro = gerador.CalcularDano(inimigo.FatorDeDano(), inimigo.Forca());
                        System.out.println("DANO do " + inimigo.Nome() + ": " + danoMonstro);
                        heroiVida = heroiVida - danoMonstro;
                        System.out.println("SUA VIDA: " + heroiVida + " Pontos De Vida");
                    }
                }
                rodadas++;
                if(heroiVida <= 0){
                    System.out.println("Você Perdeu!");
                    resultado = "PERDEU";
                }if(monstroVida <=0){
                    System.out.println("Você Ganhou!");
                    resultado = "GANHOU";
                }
            } while (heroiVida > 0 && monstroVida > 0);
        System.out.println();
        LocalDate dataAtual = LocalDate.now();
        String data = dataAtual.getDayOfMonth() + "/" + dataAtual.getMonthValue() + "/" + dataAtual.getYear();
        String heroiEscolhido = herois[heroi].Nome();

        String log = data + ";" + heroiEscolhido + ";" + resultado + ";" + inimigo.Nome() + ";" + rodadas;
        GravarLog.gravarLog(nickName,log);
    }
}