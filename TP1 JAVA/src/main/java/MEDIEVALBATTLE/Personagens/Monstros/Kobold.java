package MEDIEVALBATTLE.Personagens.Monstros;

import MEDIEVALBATTLE.Metodos.Metodos;
import MEDIEVALBATTLE.Personagens.IPersonagem;


public class Kobold implements IPersonagem {
    private String nome = "Kobold";
    private int PdV = 20;
    private int força = 4;
    private int agilidade = 4;
    private int defesa = 2;

    public int FatorDeDano()
    {
        Metodos gerador = new Metodos();
        return gerador.DadoD2() + gerador.DadoD2() + gerador.DadoD2();
    }

    @Override
    public String toString() {
        return "Kobold{" +
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

