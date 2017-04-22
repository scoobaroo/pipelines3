/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pipelines;

public class Pipeline{
    public static boolean DATA_DRIVEN;
    /**
     * @param bool
     */
    public Pipeline(boolean bool){
        Pipeline.DATA_DRIVEN = bool;
    }
    @SuppressWarnings("unchecked")
	public static void connect(@SuppressWarnings("rawtypes") Filter filter1,@SuppressWarnings("rawtypes") Filter filter2){
        @SuppressWarnings("rawtypes")
		Pipe pipe= new Pipe();
        filter1.setOutputPipe(pipe);
        filter2.setInputPipe(pipe);
    }
    public static void main(String[] args) {
        System.out.println("Inside Pipelines Application");// TODO code application logic here
    }
}
