package machine;
import images.*;

import java.util.ArrayList;
import java.util.Collections;

public class Slot {
    ArrayList<Image> images;
    protected int theme;
    public int rows;

    public Slot(int theme){
        // regardless of the theme,
        this.images = new ArrayList<>();
        this.theme = theme % 2;

        this.populateSlot();
    }
    public void shuffleDeck(){
        Collections.shuffle(this.images);
    }

    // genereate images for slot
    private void populateSlot(){
        Image img;
        switch(this.theme){
            case 0:
                for(int i = 0; i < Pirate.COUNT; i++){
                    img = new Pirate(i);
                    this.images.add( img);
                }
                break;
            case 1:
                for(int i = 0; i < Fruit.COUNT; i++){
                    img = new Fruit(i);
                    this.images.add( img );
                }
                break;
        }
        this.rows = this.images.size();
    }

    public int getRows() {
        return this.rows;
    }
    public Image getImage(int row){
        if(row >= this.rows)
            return null;
        return this.images.get(row);
    }

}
