package images;

public class Fruit extends Image {
    final static public int COUNT = 3;
    public Fruit(int codeName){
        this.codeName = codeName;
    }

    public String getName(){
        String name = "";
        switch(this.codeName) {
            case 0:
                name = "Apple";
                break;
            case 1:
                name = "Banana";
                break;
            case 2:
                name = "Cherry";
                break;
        }
        return name;
    }

    public String getName(int codeName){
        String name = "";
        switch(codeName) {
            case 0:
                name = "Apple";
                break;
            case 1:
                name = "Banana";
                break;
            case 2:
                name = "Cherry";
                break;
        }
        return name;
    }


}
