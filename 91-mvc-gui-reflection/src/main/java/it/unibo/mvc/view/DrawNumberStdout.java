package it.unibo.mvc.view;

import it.unibo.mvc.api.DrawNumberController;
import it.unibo.mvc.api.DrawNumberView;
import it.unibo.mvc.api.DrawResult;

public class DrawNumberStdout implements DrawNumberView{

    @Override
    public void start() {
        System.out.println("A new game started");
    }

    @Override
    public void result(DrawResult res) {
        System.out.println(res.getDescription());
    }

    @Override
    public void setController(DrawNumberController observer) {
        
    }
    
}
