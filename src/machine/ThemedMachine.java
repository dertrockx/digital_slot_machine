package machine;
import java.util.*;
import images.*;
public class ThemedMachine extends GenericSlotMachine {
    protected int theme;

    public ThemedMachine(int theme){
        this.slotCollection = new ArrayList<>();
        this.theme = theme;
        this.slots = this.generateRandomNumber(3, 7);
        this.drawnImageCodeNames = new int[this.slots];
        this.drawnImageNames = new String[this.slots];
        this.generateSlots();
    }

    public void play(){
        for(int i = 0; i < this.slots; i++){
            Slot slot = this.slotCollection.get(i);
            slot.shuffleDeck();
        }
    }

    public String draw(){
        // loop through slots
        Slot slot = this.slotCollection.get(0);
        int indexToDraw = generateRandomNumber(0, slot.getRows()-1);
        for(int i = 0; i < this.slotCollection.size(); i++){
            // get image at drawnIndex
            slot = this.slotCollection.get(i);
            Image img = slot.getImage(indexToDraw);
            this.drawnImageCodeNames[i] = img.getCodeName();
            this.drawnImageNames[i] = img.getName();
        }
        super.draw();
        return null;
    }

    private void generateSlots(){
//        Slot slot = new Slot(0);
//        this.slotCollection.add(slot);
        for(int i = 0; i < this.slots; i++){
            Slot slot = new Slot(this.theme);
            this.slotCollection.add(slot);
        }
    }

    public void displaySlots(){

        for(int i = 0; i < this.slots; i++){
            Slot slot = this.slotCollection.get(i);
            System.out.print("Slot " + i + ": ");
            for(int j = 0; j < slot.rows; j++){
                Image img = slot.getImage(j);
                System.out.print("\""+ img.getName() + "\" " );
            }
            System.out.println();
        }
    }

    public void displayImageFrequency(){
        for(int i = 0; i < this.drawnImageNames.length; i++){
            System.out.println(
                    this.drawnImageNames[i] + " (" + this.drawnImageCodeNames[i] + ") : " + this.frequencyArray[i]
            );
        }
    }

    private int generateRandomNumber(int min, int max){
        Random r = new Random();
        return r.nextInt( (max - min) + 1 ) + min;
    }

    @Override
    public String getImageStr(int num) {
        return null;
    }
}
