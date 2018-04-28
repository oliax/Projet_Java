package com.itii.planning.gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;

public class MainPanel extends JPanel
{
    HeaderPanel hpanel;
    ButtonPanel bpanel;
    TaskPanel tpanel;

    
    public HeaderPanel getHeaderPanel()
    {
        if(hpanel==null)
        {
            hpanel = new HeaderPanel();
        }
        return hpanel;
    }
    
    
    public ButtonPanel getButtonPanel()
    {
        if(bpanel==null)
        {
            bpanel = new ButtonPanel();
        }
        return bpanel;
    }
    
    public TaskPanel getTaskPanel()
    {
        if(tpanel==null)
        {
            tpanel = new TaskPanel();
        }
        return tpanel;
    }
    
    
    public MainPanel()
    {
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        
        gbc.gridx = 0;
        gbc.gridy = 0; // la grille commence en (0, 0)
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
        gbc.gridwidth = GridBagConstraints.RELATIVE; // seul composant de sa colonne, il est donc le dernier.
        gbc.gridheight = 1; // valeur par défaut - peut s'étendre sur une seule ligne.

        gbc.insets = new java.awt.Insets(5, 10, 5, 10);
        this.add(getHeaderPanel(),gbc);
        

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.BOTH;
        
        gbc.gridwidth = GridBagConstraints.RELATIVE; // seul composant de sa colonne, il est donc le dernier.
        gbc.gridheight = 1; // valeur par défaut - peut s'étendre sur une seule ligne.
        
        gbc.weightx = 1.;
        gbc.weighty = 1.;

        gbc.anchor = GridBagConstraints.LINE_START; // ou BASELINE_LEADING mais pas WEST.

        this.add(getTaskPanel(),gbc);
        
        
        gbc.gridx =1;
        gbc.gridy = 1; 

        gbc.gridwidth = GridBagConstraints.REMAINDER; // seul composant de sa colonne, il est donc le dernier.
        gbc.gridheight = 1; // valeur par défaut - peut s'étendre sur une seule ligne.

        gbc.weightx = .1;
        gbc.weighty = .1;
        
        gbc.anchor = GridBagConstraints.LINE_START; // ou BASELINE_LEADING mais pas WEST.
        this.add(getButtonPanel(),gbc);

    }
}
