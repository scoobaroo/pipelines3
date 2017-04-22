/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pipelines;

/**
 *
 * @author suejanehan
 */
public abstract class Producer<Data> extends Filter<Data>{
    public Producer(){
    }
    public abstract Data produce();
    public void start(){
        System.out.println("Inside start function of Producer");
        while(true){
        	System.out.println("Producing Data inside Producer class");
            Data data = produce();
            Message<Data> message=new Message<Data>(data);
            if (data==null) {
                message.quit=true;
                outPipe.write(message);
                break;
            }
            outPipe.write(message);
        }
    }

    public void update(){
        System.out.println("Inside update function of Producer");
        Data d = produce();
        Message<Data> m = new Message<Data>(d);
        if(d==null){
        	m.quit=true;
        	outPipe.write(m);
        }
        outPipe.write(m);
    }
}
