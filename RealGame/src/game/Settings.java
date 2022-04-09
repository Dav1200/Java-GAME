package game;

import city.cs.engine.SoundClip;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
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

    private static SoundClip ui;
    static{
        try {
            ui = new SoundClip("Sound/ui2.wav");

            // Open an audio input stream
            // stage1.loop();                              // Set it to continous playback (looping)
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            //code in here will deal with any errors
            //that might occur while loading/playing sound
            System.out.println(e);
        }
    }


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

        resetButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered (java.awt.event.MouseEvent evt){
                resetButton.setBackground(Color.GREEN);
                ui.play();

            }

            public void mouseExited (java.awt.event.MouseEvent evt){
                resetButton.setBackground(UIManager.getColor("control"));
            }
        });

       NextStage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered (java.awt.event.MouseEvent evt){
                NextStage.setBackground(Color.GREEN);
                ui.play();

            }

            public void mouseExited (java.awt.event.MouseEvent evt){
                NextStage.setBackground(UIManager.getColor("control"));
            }
        });
        PreviousStage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered (java.awt.event.MouseEvent evt){
                PreviousStage.setBackground(Color.GREEN);
                ui.play();

            }

            public void mouseExited (java.awt.event.MouseEvent evt){
                PreviousStage.setBackground(UIManager.getColor("control"));
            }
        });

        Close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered (java.awt.event.MouseEvent evt){
                Close.setBackground(Color.RED);
                ui.play();

            }

            public void mouseExited (java.awt.event.MouseEvent evt){
                Close.setBackground(UIManager.getColor("control"));
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


