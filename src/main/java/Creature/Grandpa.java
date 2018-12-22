package Creature;

public class Grandpa extends Creature {
    public Grandpa(){
        super();
        appearence = "file:src/main/resources/grandpa.png";
        property = 1;//代表好人
    }
    @Override
    public int GetAttack(){
        return (int)Math.random()*10 - 3;
    }
}
