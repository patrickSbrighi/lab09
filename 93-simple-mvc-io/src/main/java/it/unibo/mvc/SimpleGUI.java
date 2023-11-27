package it.unibo.mvc;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {

    private final JFrame frame = new JFrame();
    private static final int PROPORTION = 2;

    private SimpleGUI(Controller control){
        frame.setTitle("My first java graphical interface");
        JPanel pane = new JPanel();
        pane.setLayout(new BorderLayout());
        JButton button = new JButton("Save");
        pane.add(button, BorderLayout.SOUTH);
        JTextArea text = new JTextArea();
        pane.add(text);
        frame.setContentPane(pane);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        
        //Set dimension
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        frame.setSize(sw / PROPORTION, sh / PROPORTION);
        frame.setLocationByPlatform(true);

        button.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e){
                try{
                    control.saveString(text.getText());
                }catch(IOException exception){
                    JOptionPane.showMessageDialog(null,exception.getMessage());
                }
            }
        });
    }

    private void start(){
        frame.setVisible(true);
    }

    public static void main(String... a){
        SimpleGUI gui = new SimpleGUI(new Controller());
        gui.start();
    }

}
