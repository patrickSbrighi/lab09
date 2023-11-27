package it.unibo.mvc;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUIWithFileChooser {

    private final JFrame frame = new JFrame();
    private static final int PROPORTION = 2;


    private SimpleGUIWithFileChooser(Controller control){
        frame.setTitle("My second java graphical interface");

        JPanel pane1 = new JPanel();
        pane1.setLayout(new BorderLayout());
        JTextField showPath = new JTextField();
        showPath.setEditable(false);
        showPath.setText(control.getFilePath());
        JButton browse = new JButton("Browse...");
        pane1.add(showPath, BorderLayout.CENTER);
        pane1.add(browse, BorderLayout.LINE_END);

        JPanel pane2 = new JPanel();
        pane2.setLayout(new BorderLayout());
        JButton button = new JButton("Save");
        pane2.add(button, BorderLayout.SOUTH);
        JTextArea text = new JTextArea();
        pane2.add(text, BorderLayout.CENTER);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(pane1, BorderLayout.NORTH);
        panel.add(pane2);

        frame.setContentPane(panel);
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

        browse.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser choser = new JFileChooser();
                if(choser.showSaveDialog(panel) == JFileChooser.APPROVE_OPTION){
                    control.setFile(choser.getSelectedFile().getPath());
                    showPath.setText(control.getFilePath());
                }
            }
            
        });
    }

    private void start(){
        frame.setVisible(true);
    }

    public static void main(String... a){
        SimpleGUIWithFileChooser sc = new SimpleGUIWithFileChooser(new Controller());
        sc.start();
    }

}
