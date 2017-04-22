package garbageband;
import pipelines.*;
/**
 *
 * @author suejanehan
 */

public class GarbageBand extends Pipeline{

//    private Note amplify(Note n){
//        if(n.amplitude<50) n.amplitude = 50;
//        if(n.amplitude>127) n.amplitude =127;
//        return n;
//    }
//    public boolean testFrequency(Note n){
//        return 0<=n.frequency && n.frequency<=127;
//    }
//    public boolean testDuration(Note n){
//        return 0<=n.duration && n.duration<1500;
//    }
    public GarbageBand(boolean bool){
        super(bool);
    }
    
    @SuppressWarnings("static-access")
	public static void main(String[] args) {
        System.out.println("Inside main function of GarbageBand");
        GarbageBand gb = new GarbageBand(true);
        Composer composer = new Composer();
        Amplifier amplifier = new Amplifier();
        FrequencyFilter frequencyFilter = new FrequencyFilter();
        DurationFilter durationFilter = new DurationFilter();
        AmplitudeFilter amplitudeFilter = new AmplitudeFilter();
        Player player = new Player();
        gb.connect(composer,amplifier);
        gb.connect(amplifier,frequencyFilter);
        gb.connect(frequencyFilter,durationFilter);
        gb.connect(durationFilter,amplitudeFilter);
        gb.connect(amplitudeFilter,player);
        composer.start();
//        GarbageBand gb2 = new GarbageBand(false);
//        Composer composer2 = new Composer();
//        Amplifier amplifier2 = new Amplifier();
//        FrequencyFilter frequencyFilter2 = new FrequencyFilter();
//        DurationFilter durationFilter2 = new DurationFilter();
//        AmplitudeFilter amplitudeFilter2 = new AmplitudeFilter();
//        Player player2 = new Player();
//        gb2.connect(composer2,amplifier2);
//        gb2.connect(amplifier2,frequencyFilter2);
//        gb2.connect(frequencyFilter2,durationFilter2);
//        gb2.connect(durationFilter2,amplitudeFilter2);
//        gb2.connect(amplitudeFilter2,player2);
//        player2.start();
    }
}
