package MEDIEVALBATTLE.Metodos;

import MEDIEVALBATTLE.Personagens.IPersonagem;
import MEDIEVALBATTLE.Personagens.Monstros.Kobold;
import MEDIEVALBATTLE.Personagens.Monstros.MortoVivo;
import MEDIEVALBATTLE.Personagens.Monstros.Orc;

import java.util.Date;
import java.util.Random;

public class Metodos {
    Random generator = new Random();
    public int DadoD10()
    {
        return generator.nextInt(10) + 1;
    }
    public int DadoD4()
    {
        return generator.nextInt(4) + 1;
    }
    public int DadoD6()
    {
        return generator.nextInt(6) + 1;
    }
    public int DadoD8()
    {
        return generator.nextInt(8) + 1;
    }
    public int DadoD2()
    {
        return generator.nextInt(2) + 1;
    }
    public IPersonagem GerarInimigo()
    {
        Kobold kobold = new Kobold();
        MortoVivo mortoVivo = new MortoVivo();
        Orc orc = new Orc();

        int numeroAleatorio = generator.nextInt(3);
        if(numeroAleatorio == 0){
            return kobold;
        }else if(numeroAleatorio == 1){
            return mortoVivo;
        }else if(numeroAleatorio == 2){
            return orc;
        }else throw new RuntimeException();
    }

    public int CalculadoraIniciativa(int agilidade)
    {
        return DadoD10() + agilidade;
    }
    public int CalculadoraAtaque(int agilidade, int forca)
    {
        return DadoD10() + agilidade + forca;
    }
    public int CalcularDefesa(int agilidade,int defesa)
    {
        return DadoD10() + agilidade + defesa;
    }
    public int CalcularDano(int fatorDano, int forca)
    {
        return fatorDano + forca;
    }

}
