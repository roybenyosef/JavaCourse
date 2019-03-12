package app.core.concurrency2;

import java.util.ArrayList;
import java.util.List;

public class Stack {

    private List<Integer> data=new ArrayList<>();

    public synchronized void push(Integer i){
        notify();
        System.out.println("Adding: "+i+" ("+data.size()+")");
        data.add(i);
    }

    public synchronized int pop(){
        while(data.isEmpty()){
            System.out.println("Waiting....");
            try{wait();}catch(Exception e){}
        }
        Integer i=data.remove(data.size()-1);
        System.out.println("poped: "+i+" ("+data.size()+")");
        return i;
    }


}