package it.unibo.mvc;

import java.util.List;

/**
 *
 */
public interface Controller {
    
    void setNextString(String str);

    String getNextString();

    List<String> getHistory();

    void print() throws IllegalStateException;
}
