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

    public Settings(Game g){

    Close.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            g.frame.remove(MainPanel);
            g.frame.repaint();
            g.frame.validate();

        }
    });



    }

}


