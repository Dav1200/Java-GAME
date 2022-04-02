package game;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Settings {
    private JSlider slider1;

    public JPanel getMainPanel() {
        return MainPanel;
    }

    protected JPanel MainPanel;
    private JButton NextStage;
    private JButton PreviousStage;
    private JButton Close;
    private Gamelevel gamelevel;

    public Settings(Game g,Gamelevel gamelevel){
    this.gamelevel = gamelevel;
    Close.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            g.frame.remove(MainPanel);
            g.frame.repaint();
            g.frame.validate();

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


