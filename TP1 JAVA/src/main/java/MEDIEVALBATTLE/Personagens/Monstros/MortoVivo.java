package MEDIEVALBATTLE.Personagens.Monstros;

import MEDIEVALBATTLE.Metodos.Metodos;
import MEDIEVALBATTLE.Personagens.IPersonagem;


public class MortoVivo implements IPersonagem {
    private String nome = "Morto-Vivo";
    private int PdV = 25;
    private int força = 4;
    private int agilidade = 1;
    private int defesa = 0;
    public int FatorDeDano()
    {
        Metodos gerador = new Metodos();
        return gerador.DadoD4() + gerador.DadoD4();
    }
    @Override
    public String toString() {
        return "MortoVivo{" +
                "PdV=" + PdV +
                ", força=" + força +
                ", agilidade=" + agilidade +
                ", defesa=" + defesa +
                '}';
    }
    @Override
    public int Vida() {
        return PdV;
    }

    @Override
    public int Forca() {
        return força;
    }

    @Override
    public int Defesa() {
        return defesa;
    }

    @Override
    public int Agilidade() {
        return agilidade;
    }

    @Override
    public String Nome() {
        return nome;
    }
}
