package Creature;

public class Snake extends Creature {
    public Snake(){
        super();
        appearence = "file:src/main/resources/snake.png";
        property = 2;//´ú±í»µÈË
    }
    @Override
    public int GetAttack(){
        return (int)Math.random()*10 + 2;
    }
}
