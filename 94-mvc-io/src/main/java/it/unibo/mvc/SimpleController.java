package it.unibo.mvc;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 *
 */
public final class SimpleController implements Controller {
    private String next;
    private List<String> history = new ArrayList<>();
    
    
    @Override
    public void setNextString(String str) {
        this.next = str;
    }

    @Override
    public String getNextString() {
        return this.next;
    }

    @Override
    public List<String> getHistory() {
        return this.history;
    }

    @Override
    public void print() throws IllegalStateException {
        if(this.next == null){
            throw new IllegalStateException();
        }
        System.out.println(this.next);
        this.history.add(this.next);
    }

}
