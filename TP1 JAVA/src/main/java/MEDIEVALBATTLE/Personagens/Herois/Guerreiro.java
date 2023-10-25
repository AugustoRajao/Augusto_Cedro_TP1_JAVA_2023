package MEDIEVALBATTLE.Personagens.Herois;
import MEDIEVALBATTLE.Metodos.Metodos;
import MEDIEVALBATTLE.Personagens.IPersonagem;

public class Guerreiro implements IPersonagem {
    private String nome = "Guerreiro";
    private int PdV = 12;
    private int força = 4;
    private int agilidade = 3;
    private int defesa = 3;

    public int FatorDeDano()
    {
        Metodos gerador = new Metodos();
        return gerador.DadoD4() + gerador.DadoD4();
    }
    @Override
    public String toString() {
        return "Guerreiro{" +
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
