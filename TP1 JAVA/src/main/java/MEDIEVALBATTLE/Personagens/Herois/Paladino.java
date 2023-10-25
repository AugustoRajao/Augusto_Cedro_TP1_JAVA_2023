package MEDIEVALBATTLE.Personagens.Herois;
import MEDIEVALBATTLE.Metodos.Metodos;
import MEDIEVALBATTLE.Personagens.IPersonagem;


public class Paladino implements IPersonagem {
    private String nome = "Paladino";
    private int PdV = 15;
    private int força = 2;
    private int agilidade = 1;
    private int defesa = 5;

    public int FatorDeDano()
    {
        Metodos gerador = new Metodos();
        return gerador.DadoD4() + gerador.DadoD4();
    }
    @Override
    public String toString() {
        return "Paladino{" +
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
