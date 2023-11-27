package it.unibo.mvc;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {

    private final JFrame frame = new JFrame();
    private static final int PROPORTION = 2;

    private SimpleGUI(Controller control){
        frame.setTitle("New java application");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        final JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        final JTextField field = new JTextField();
        panel.add(field, BorderLayout.NORTH);
        final JTextArea area = new JTextArea();
        area.setEditable(false);
        panel.add(area, BorderLayout.CENTER);

        final JPanel paneButton = new JPanel();
        paneButton.setLayout(new BoxLayout(paneButton, BoxLayout.LINE_AXIS));
        final JButton print = new JButton("Print");
        final JButton show = new JButton("Show history");
        paneButton.add(print, BorderLayout.EAST);
        paneButton.add(show, BorderLayout.WEST);
        panel.add(paneButton, BorderLayout.SOUTH);

        frame.setContentPane(panel);

        //Set dimension
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        frame.setSize(sw / PROPORTION, sh / PROPORTION);
        frame.setLocationByPlatform(true);

        print.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                control.setNextString(field.getText());
                control.print();
            }
            
        });

        show.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                area.removeAll();
                for(String s : control.getHistory()){
                    area.append(s);
                    area.append("\n");
                }
            }
            
        });
    }

    private void start(){
        frame.setVisible(true);
    }

    public static void main(String...a){
        SimpleGUI gui = new SimpleGUI(new SimpleController());
        gui.start();
    }

}
