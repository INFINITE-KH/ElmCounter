package controller;

public class Counter {
    private int add = 0;

    public Counter() {
    }
    
    public void Increment(){
       this.add++;
    }

    public int getCounter() {
        int oldAdd = add;
        Increment();
        return oldAdd;
    }

    public void setCounter(int add) {
        this.add = add;
    }
    
}
