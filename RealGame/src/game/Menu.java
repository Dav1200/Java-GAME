package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu  extends JPanel {
    public JPanel getMainPanel() {
        return MainPanel;
    }

    private JPanel MainPanel;

    public JButton getButton1() {
        return button1;
    }

    private JButton button1;
    private JButton quitButton;
    private JButton settingsButton;
    private Image background;
    private JLabel Imageicon;

    private Game game;

    public Menu(Game game){
    button1.setBounds(320,200,120,50);
    this.game = game;



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
        }
        );


    }



    private void createUIComponents() {
        // TODO: place custom component creation code here
        Imageicon = new JLabel(new ImageIcon("Platformimg/stage1r.png"));
        Imageicon.setBounds(20,100,10,10);
    }
}
