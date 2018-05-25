package com.itii.planning.gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class HeaderPanel extends JPanel
{
    JLabel choix_label = new JLabel("Vue : ");
    public MenuDeroulant menu_list = new MenuDeroulant();
    
    
    public HeaderPanel()
    {
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
        this.add(choix_label,gbc);
        gbc.gridx = 1;
        gbc.gridy = 0;
        this.add(menu_list,gbc);
    }
}
