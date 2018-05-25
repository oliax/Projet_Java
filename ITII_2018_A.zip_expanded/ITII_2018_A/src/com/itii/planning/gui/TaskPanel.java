package com.itii.planning.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;

public class TaskPanel extends JPanel
{
    PanneauList list = new PanneauList();
    PanneauSemaine semaine = new PanneauSemaine();
    PanneauMois mois = new PanneauMois();
    
    public TaskPanel()
    {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        
        gbc.gridx = 0;
        gbc.gridy = 0; // la grille commence en (0, 0)
        gbc.fill = GridBagConstraints.BOTH;
        
        gbc.weightx = 1.;
        gbc.weighty = 1.;
        
        list.setVisible(true);
        semaine.setVisible(false);
        mois.setVisible(false);
        this.add(list,gbc);
        this.add(semaine,gbc);
        this.add(mois, gbc);
    }
    
    public PanneauList getPanneauList()
    {
        if(list==null)
        {
            list = new PanneauList();
        }
        return list;
    }
    
    public PanneauSemaine getPanneauSemaine()
    {
        if(semaine==null)
        {
            semaine = new PanneauSemaine();
        }
        return semaine;
    }

    public PanneauMois getPanneauMois()
    {
        if(mois==null)
        {
            mois = new PanneauMois();
        }
        return mois;
    }

}




