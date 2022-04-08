package game;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Settings {
    private JSlider slider1;

    public JPanel getMainPanel() {
        return MainPanel;
    }

    protected JPanel MainPanel;
    private JButton NextStage;
    private JButton PreviousStage;
    private JButton Close;
    private JButton resetButton;
    private Gamelevel gamelevel;

    public Settings(Game g,Gamelevel gamelevel){
    this.gamelevel = gamelevel;

    resetButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            g.reset();
        }
    });

    Close.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            g.frame.remove(MainPanel);
            g.frame.repaint();
            g.frame.validate();

        }
    });

    NextStage.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println(gamelevel);
            try {
                gamesaverloader.save(g.getWorld(), "Saves/Save.txt");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    });

    PreviousStage.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

            try {
                Gamelevel a = gamesaverloader.load("Saves/Save.txt", g, gamelevel);
                g.setlevel(a);
                System.out.println(a);
                //player.setLives(a);
            } catch (IOException ex) {
                ex.printStackTrace();
            }

        }
    });


    ChangeListener change = new ChangeListener() {
        @Override
        public void stateChanged(ChangeEvent e) {
            //System.out.println(slider1.getValue());
            int a = slider1.getValue();
            g.volume = a;



        }
    };


        slider1.addChangeListener(change);


    }
    public void changegamelevel(Gamelevel gamelevel){
        this.gamelevel =gamelevel;
    }


}


