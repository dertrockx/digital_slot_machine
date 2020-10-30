package machine;

import images.Image;

import java.util.*;

abstract class GenericSlotMachine implements DigitalSlotMachine{

	protected int slots;

	//add attributes
	protected ArrayList<Slot> slotCollection;
	protected int[] drawnImageCodeNames;
	protected String[] drawnImageNames;

	protected int[] frequencyArray;

	protected ArrayList<String> winningImages;

	protected String event;
	/**
	 * play() method - this is where shuffling happens
	 */
	@Override
	public void play() {

	}


	/**
	 * draw() - simulates stopping/pulling down of lever of slot machine
	 * 
	 */
	public String draw() {
//		this.displayDrawnImages();
		this.displayResult();
		return null;
	}


	/**
	 * Get the frequency of each image
	 * 
	 * @param drawnImages drawnImages
	 */
	private void determineImageFrequency(int[] drawnImages) {
		this.frequencyArray = new int[ this.slots ];
		for(int i = 0; i < this.frequencyArray.length; i++){
			this.compareSlots(i);
		}
	}
	/**
	 * Compare the occurence of each image after game "draw"
	 *
	 * @param index
	 */
	private void compareSlots(int index) {
		int freqOfImageAtIndex = 0;
		for(int i = 0; i < this.drawnImageCodeNames.length; i++){
			if(this.drawnImageCodeNames[index] == this.drawnImageCodeNames[i])
				freqOfImageAtIndex++;
		}
		this.frequencyArray[index] = freqOfImageAtIndex;
	}
	/**
	 * Determine the event.
	 * The largest value must be greater than given threshold to be considered
	 * a good game.
	 * 
	 */
	
	private void determineEvent() {
		this.winningImages = new ArrayList<>();

		int mostOccurrences = frequencyArray[0];

		for(int i = 1; i < this.frequencyArray.length; i++){
			if(mostOccurrences <= frequencyArray[i]){
				mostOccurrences = frequencyArray[i];
			}
		}

		for(int i = 0; i < this.drawnImageNames.length;i++) {
			for(int j = 0; j < this.drawnImageNames.length;j++) {
				if(i == j && this.frequencyArray[j] == mostOccurrences)
					this.winningImages.add( this.drawnImageNames[i] );
			}
		}

		this.removeDuplicates();

//		prints the image/s with the highest occurrence
		for(int i = 0; i < this.winningImages.size(); i++) {
			String str = this.winningImages.get(i);
			System.out.print(str+" ");
		}
		System.out.println("- "+mostOccurrences+"/"+this.slots+" slots");

		this.displayDrawnImages();

		// check the event
		double game = (double) mostOccurrences / this.slots;

		if(game == 1.0){
			System.out.println("Event: " + this.WINNER);
			this.event = this.WINNER;
		} else if( game > this.GOOD_GAME_PERCENTAGE){
			System.out.println("Event: " + this.GOOD_GAME);
			this.event = this.GOOD_GAME;
		} else {
			System.out.println("Event: " + this.LOSER);
			this.event = this.LOSER;
		}

	}

	private void removeDuplicates(){
		Set<String> set = new LinkedHashSet<>(this.winningImages);
		this.winningImages.clear();
		this.winningImages.addAll(set);
	}




	
	public abstract String getImageStr(int num);


	/**
	 * Displays the drawn images (text)
	 * 
	 */
	private void displayDrawnImages() {
		for(int i = 0; i < this.drawnImageNames.length; i++){
			System.out.print("[" + drawnImageNames[i] + "] ");
		}
		System.out.println();
	}

	
	/**
	 * Displays the event/result (win,lose,good game)
	 */
	private void displayResult() {
		this.determineImageFrequency(this.drawnImageCodeNames);
		this.determineEvent();
	}
	
	
}
