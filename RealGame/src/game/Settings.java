package game;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

public class Settings {
    private JSlider slider1;

    public JPanel getMainPanel() {
        return MainPanel;
    }
private String b;
    protected JPanel MainPanel;
    private JButton NextStage;
    private JButton PreviousStage;
    private JButton Close;
    private JButton resetButton;
    private Gamelevel gamelevel;

    public Settings(Game g,Gamelevel gamelevel){
    this.gamelevel = gamelevel;
    b = null;

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
            JFileChooser jfile = new JFileChooser("saves/");
            int select = jfile.showSaveDialog(null);
            if(select == JFileChooser.APPROVE_OPTION){
                b = jfile.getSelectedFile().getAbsolutePath();
                try {
                    FileWriter write = new FileWriter(b);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                System.out.println(b);
            }
            else{
                System.out.println("cancel");
            }
            try {
                gamesaverloader.save(g.getWorld(), b);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    });

    PreviousStage.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

            JFileChooser jfile = new JFileChooser("saves/");
         int select = jfile.showDialog(null,"Openfile");
         if(select == JFileChooser.APPROVE_OPTION){
             b = jfile.getSelectedFile().getAbsolutePath();
             System.out.println(b);
         }
         else{
             System.out.println("cancel");
         }

            try {
                Gamelevel a = gamesaverloader.load(b, g, gamelevel);
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


