package Creature;

public class Snake extends Creature {
    public Snake(){
        super();
        appearence = "file:src/main/resources/snake.png";
        property = 2;//������
    }
    @Override
    public int GetAttack(){
        return (int)Math.random()*10 + 2;
    }
}
