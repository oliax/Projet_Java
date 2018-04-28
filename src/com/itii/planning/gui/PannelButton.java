package com.itii.planning.gui;

import javax.swing.JButton;

public class PannelButton extends JButton
{
    JButton boutonCréer = new JButton("Créer");
    JButton boutonEditer = new JButton("Editer");
    JButton boutonMarquer = new JButton("Marquer");
    JButton boutonDupliquer = new JButton("Dupliquer");
    JButton boutonSupprimer = new JButton("Supprimer");
    
    public PannelButton()
    {
        this.add(boutonCréer);
        this.add(boutonEditer);
        this.add(boutonMarquer);
        this.add(boutonDupliquer);
        this.add(boutonSupprimer);
    }

}
