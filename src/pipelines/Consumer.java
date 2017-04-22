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
public abstract class Consumer<Data> extends Filter<Data>{
    public Consumer(){
    }
    public abstract void consume(Data input);
    public void start(){
        while(true){
            System.out.println("Inside start method of Consumer");
            Message<Data> m = inPipe.read();
            Data d = (Data) m.content;
            if(m.quit!=true) consume(d);
            else if(m.quit==true) break;
        }
    }
    public void update(){
    	System.out.println("Inside update method of Consumer");
    	Message<Data> m = inPipe.read();
    	if(m.quit!=true && !m.fail && m.content != null) consume(m.content);
    }
}
