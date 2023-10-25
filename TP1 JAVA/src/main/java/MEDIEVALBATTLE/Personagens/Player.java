package MEDIEVALBATTLE.Personagens;

import MEDIEVALBATTLE.Personagens.IPersonagem;

public class Player {
    private String nickName;
    private IPersonagem classe;
    public Player(String nickName, IPersonagem classe) {
        this.nickName = nickName;
        this.classe = classe;
    }
    @Override
    public String toString() {
        return "Player{" +
                "nickName='" + nickName + '\'' +
                ", classe=" + classe +
                '}';
    }
}
