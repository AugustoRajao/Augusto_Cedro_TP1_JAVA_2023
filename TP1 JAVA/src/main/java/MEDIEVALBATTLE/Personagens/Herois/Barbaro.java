package MEDIEVALBATTLE.Personagens.Herois;
import MEDIEVALBATTLE.Metodos.Metodos;
import MEDIEVALBATTLE.Personagens.IPersonagem;

public class Barbaro implements IPersonagem {
    private String nome = "Bárbaro";
    private int PdV = 13;
    private int força = 6;
    private int agilidade = 3;
    private int defesa = 1;

    public int FatorDeDano()
    {
        Metodos gerador = new Metodos();
        return gerador.DadoD6() + gerador.DadoD6();
    }
    @Override
    public String toString() {
        return "Barbaro{" +
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
