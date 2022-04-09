package game;

import city.cs.engine.SoundClip;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Menu extends JPanel {
    public JPanel getMainPanel() {
        return MainPanel;
    }

    private JPanel MainPanel;

    public JButton getButton1() {
        return button1;
    }

    private JButton button1;

    public JButton getQuitButton() {
        return quitButton;
    }

    private JButton quitButton;

    public JButton getSettingsButton() {
        return settings;
    }

    private JButton settings;
    private Image background;
    private JLabel Imageicon;

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


    private Game game;

    public Menu(Game game) {
        button1.setBounds(340, 100, 120, 50);
        quitButton.setBounds(340, 400, 120, 50);
        settings.setBounds(340, 250, 120, 50);
        this.game = game;

        settings.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered (java.awt.event.MouseEvent evt){
                settings.setBackground(Color.GREEN);
                ui.play();

            }

            public void mouseExited (java.awt.event.MouseEvent evt){
                settings.setBackground(UIManager.getColor("control"));
            }
        });

        button1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered (java.awt.event.MouseEvent evt){
                button1.setBackground(Color.GREEN);  ui.play();
            }

            public void mouseExited (java.awt.event.MouseEvent evt){
                button1.setBackground(UIManager.getColor("control"));
            }
        });

        quitButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered (java.awt.event.MouseEvent evt){
                quitButton.setBackground(Color.RED);  ui.play();
            }

            public void mouseExited (java.awt.event.MouseEvent evt){
                quitButton.setBackground(UIManager.getColor("control"));
            }
        });


        settings.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("hi");
                game.frame.add(game.getSettings().getMainPanel(), BorderLayout.SOUTH);
                game.frame.repaint();
                game.frame.validate();
            }
        });

        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("hi");

                game.Pause();


            }
        });


    }


    private void createUIComponents() {
        // TODO: place custom component creation code here
        Imageicon = new JLabel(new ImageIcon("Platformimg/stage1r.png"));
        Imageicon.setBounds(20, 100, 10, 10);
    }
}
