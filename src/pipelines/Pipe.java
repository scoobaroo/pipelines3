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
public class Pipe<Data> extends Publisher{

    Message<Data> message;

    public Pipe(){
        
    }
    public Message<Data> read(){
    	Thread.yield();
        if(!Pipeline.DATA_DRIVEN){
            notifySubscribers();
        }
        return this.message;
    }
    public void write(Message<Data> msg){
    	Thread.yield();
        this.message = msg;
        if(Pipeline.DATA_DRIVEN){
            notifySubscribers();
        }
    }
}
