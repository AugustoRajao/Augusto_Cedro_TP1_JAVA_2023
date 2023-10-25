package ProgramaDeRelatorios;

public class Relatorio {
    String data;
    String heroiEscolhido;
    String resultadoPartida;
    String monstroEnfrentado;
    String quantidadeRodadas;

    public Relatorio(String data, String heroiEscolhido, String resultadoPartida, String monstroEnfrentado, String quantidadeRodadas) {
        this.data = data;
        this.heroiEscolhido = heroiEscolhido;
        this.resultadoPartida = resultadoPartida;
        this.monstroEnfrentado = monstroEnfrentado;
        this.quantidadeRodadas = quantidadeRodadas;
    }

    public String getData() {
        return data;
    }

    public String getHeroiEscolhido() {
        return heroiEscolhido;
    }

    public String getResultadoPartida() {
        return resultadoPartida;
    }

    public String getMonstroEnfrentado() {
        return monstroEnfrentado;
    }

    public String getQuantidadeRodadas() {
        return quantidadeRodadas;
    }
}
