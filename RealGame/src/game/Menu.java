package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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


    private Game game;

    public Menu(Game game) {
        button1.setBounds(340, 100, 120, 50);
        quitButton.setBounds(340,400,120,50);
        settings.setBounds(340,250,120,50);
        this.game = game;


        settings.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            game.frame.add(game.getSettings().getMainPanel(),BorderLayout.SOUTH);
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
