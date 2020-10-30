package images;

public class Pirate extends Image {
    final static public int COUNT = 5;
    public Pirate(int codeName){
        this.codeName = codeName;
    }

    public String getName(){
        String name = "";
        switch(this.codeName) {
            case 0:
                name = "Skull";
                break;
            case 1:
                name = "Pirate mate";
                break;
            case 2:
                name = "Anchor";
                break;
            case 3:
                name = "Treasure Map";
                break;
            case 4:
                name = "Gun";
                break;
        }
        return name;
    }

//    @Override
    public String getName(int codeName){
        String name = "";
        switch(codeName) {
            case 0:
                name = "Skull";
                break;
            case 1:
                name = "Pirate mate";
                break;
            case 2:
                name = "Anchor";
                break;
            case 3:
                name = "Treasure Map";
                break;
            case 4:
                name = "Gun";
                break;
        }
        return name;
    }

}
