package com.itii.planning.gui;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

public class MenuDeroulant extends JComboBox implements ItemListener
{
    Listing menu_deroulant;
   
    public MenuDeroulant()
    {
        this.addItem(menu_deroulant.Liste);
        this.addItem(menu_deroulant.Semaine);
        this.addItem(menu_deroulant.Mois);
        this.addItemListener(this);
        this.addActionListener(this);
    }

    @Override
    public void itemStateChanged(ItemEvent item_event)
    {
        System.out.println("EventListener : event sur " + item_event.getItem());
        System.out.println("ActionListener : action sur " + this.getSelectedItem());  
//        if(item_event.getStateChange()==item_event.SELECTED)
//        {
//            if(this.getSelectedItem().toString().equals("Liste"))
//            {
//                System.out.println("Liste");
//            }
//            
//        }
//        
    }
    
    public void action(ActionEvent item_action)
    {
        System.out.println("ActionListener : action sur " + this.getSelectedItem());      
    }
}
