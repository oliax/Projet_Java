package com.itii.planning.gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;

import javafx.geometry.Insets;

public class MainPanel extends JPanel
{
    ButtonPannel ButtonPannel = new ButtonPannel();
    MenuDeroulant menu_list = new MenuDeroulant();
    PanneauList list = new PanneauList();
    PanneauSemaine semaine = new PanneauSemaine();
    PanneauMois mois = new PanneauMois();
    
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
        this.add(menu_list,gbc);
        

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.BOTH;
        
        gbc.gridwidth = GridBagConstraints.RELATIVE; // seul composant de sa colonne, il est donc le dernier.
        gbc.gridheight = 1; // valeur par défaut - peut s'étendre sur une seule ligne.
        
        gbc.weightx = 1.;
        gbc.weighty = 1.;

        gbc.anchor = GridBagConstraints.LINE_START; // ou BASELINE_LEADING mais pas WEST.

        this.add(list,gbc);
        
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 1;

        gbc.gridwidth = GridBagConstraints.RELATIVE; // seul composant de sa colonne, il est donc le dernier.
        gbc.gridheight = 1; // valeur par défaut - peut s'étendre sur une seule ligne.

        gbc.anchor = GridBagConstraints.LINE_START; // ou BASELINE_LEADING mais pas WEST.

        this.add(semaine,gbc);
        
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 1;

        gbc.gridwidth = GridBagConstraints.RELATIVE; // seul composant de sa colonne, il est donc le dernier.
        gbc.gridheight = 1; // valeur par défaut - peut s'étendre sur une seule ligne.
        
        gbc.anchor = GridBagConstraints.LINE_START; // ou BASELINE_LEADING mais pas WEST.

        this.add(mois,gbc);
        
        
        gbc.gridx =1;
        gbc.gridy = 1; 

        gbc.gridwidth = GridBagConstraints.REMAINDER; // seul composant de sa colonne, il est donc le dernier.
        gbc.gridheight = 1; // valeur par défaut - peut s'étendre sur une seule ligne.

        gbc.weightx = .1;
        gbc.weighty = .1;
        
        gbc.anchor = GridBagConstraints.LINE_START; // ou BASELINE_LEADING mais pas WEST.
        this.add(ButtonPannel,gbc);

    }
}
