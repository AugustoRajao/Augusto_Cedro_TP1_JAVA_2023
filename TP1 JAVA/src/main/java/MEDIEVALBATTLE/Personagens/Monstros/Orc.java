package MEDIEVALBATTLE.Personagens.Monstros;

import MEDIEVALBATTLE.Metodos.Metodos;
import MEDIEVALBATTLE.Personagens.IPersonagem;

public class Orc implements IPersonagem {
    private String nome = "Orc";
    private int PdV = 20;
    private int força = 6;
    private int agilidade = 2;
    private int defesa = 2;

    public int FatorDeDano()
    {
        Metodos gerador = new Metodos();
        return gerador.DadoD8();
    }
    @Override
    public String toString() {
        return "Orc{" +
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
