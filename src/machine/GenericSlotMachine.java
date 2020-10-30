package machine;

import images.Image;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;

abstract class GenericSlotMachine implements DigitalSlotMachine{

	protected int slots;

	//add attributes
	protected ArrayList<Slot> slotCollection;
	protected int[] drawnImageCodeNames;
	protected String[] drawnImageNames;

	protected int[] frequencyArray;
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
		this.displayDrawnImages();
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
