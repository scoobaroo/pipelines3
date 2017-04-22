/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garbageband;
/**
 *
 * @author suejanehan
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
*/
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Synthesizer;
import pipelines.Consumer;

/**
 *
 * @author suejanehan
 */
public class Player extends Consumer<Note>{
    float frequency = 44100;
    
    Synthesizer synth;
    MidiChannel channel;

    public Player(){
    	try{
    	synth = MidiSystem.getSynthesizer();
        synth.open();
        channel = synth.getChannels()[0];
    	}
    	catch(Exception e){
    		e.printStackTrace();
    	}
    }
    
    public void consume(Note note) {
        System.out.println("Inside Consume function of Player");
        Note n = note;
        try {
            channel.noteOn( n.frequency , n.amplitude );
            Thread.sleep(n.duration);
            channel.noteOff(n.frequency);
        } catch (InterruptedException ex) {
            Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void update(){
        System.out.println("Inside update function of player");
        super.update();
    }

}
