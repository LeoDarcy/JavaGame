package Creature;
public class CreateFactory {
    private int huluwa_index;
    public CreateFactory(){huluwa_index = 1;}
    public Object Creature(ItemType type){
        switch (type)
        {
            case Rock:return CreateRock();
            case Huluwa:return CreateHuluwa();
            case Grandpa:return CreateGrandpa();
            case BadGuy:return CreateBadguy();
            case Snake:return CreateSnake();
            case Background:return CreateBackground();
            default:return CreateBackground();
        }
    }
    public Object CreateBlocked(String maptype){
        if(maptype.equals("山林")){
            return CreateRock();
        }
        else if(maptype.equals("江河")){
            return CreateWater();
        }
        else{
            return CreateRock();
        }
    }
    public Rock CreateRock(){
        return new Rock();
    }
    public Huluwa CreateHuluwa(){
        Huluwa born = new Huluwa();
        switch (huluwa_index){
            case 1:born.SetAppearance("file:src/main/resources/huluwa1.png");break;
            case 2:born.SetAppearance("file:src/main/resources/huluwa2.png");break;
            case 3:born.SetAppearance("file:src/main/resources/huluwa3.png");break;
            case 4:born.SetAppearance("file:src/main/resources/huluwa4.png");break;
            case 5:born.SetAppearance("file:src/main/resources/huluwa5.png");break;
            case 6:born.SetAppearance("file:src/main/resources/huluwa6.png");break;
            case 7:born.SetAppearance("file:src/main/resources/huluwa7.png");break;
        }
        huluwa_index++;
        huluwa_index = huluwa_index%7;
        return born;
    }
    public Grandpa CreateGrandpa(){
        return new Grandpa();
    }
    public Snake CreateSnake(){
        return new Snake();
    }
    public Badguy CreateBadguy(){
        return new Badguy();
    }
    public Grass CreateBackground(){
        return new Grass();
    }
    public Water CreateWater(){return new Water();}
}
