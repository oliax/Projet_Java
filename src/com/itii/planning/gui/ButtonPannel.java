package com.itii.planning.gui;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class ButtonPannel extends JPanel
{
    JButton boutonCreer = new JButton("Creer");
    JButton boutonEditer = new JButton("Editer");
    JButton boutonMarquer = new JButton("Marquer");
    JButton boutonDupliquer = new JButton("Dupliquer");
    JButton boutonSupprimer = new JButton("Supprimer");
      
    public ButtonPannel()
    {
        this.setLayout(new GridLayout(5,1));
        this.add(boutonCreer);
        this.add(boutonEditer);
        this.add(boutonMarquer);
        this.add(boutonDupliquer);
        this.add(boutonSupprimer);
    }

}
