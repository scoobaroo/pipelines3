/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garbageband;
import pipelines.*;
import java.util.Random;

/**
 *
 * @author suejanehan
 */
public class Composer extends Producer<Note>{
	Random rand = new Random();
	int numNotes = 0;
	int maxNotes = 50;
    public Composer() {

    }
    
    public Note produce() {
    	while(numNotes<maxNotes){
	        System.out.println("Inside produce function of Composer");
	        int frequency = rand.nextInt(127);
	        int amplitude = rand.nextInt(1000);
	        int duration = rand.nextInt(2000);
	        Note note = new Note(frequency,amplitude,duration);
	        numNotes++;
	        return note;
    	}
    	return null;
    }
    
    public void update() {
        System.out.println("Inside update function of Composer");
        super.update();
    }

    public void start() {
        System.out.println("Inside start function of Composer");
        super.start();
    }
    
}
