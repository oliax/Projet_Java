package com.itii.planning.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

public class MenuDeroulant extends JComboBox implements ActionListener
{
    Listing menu_deroulant;

    public MenuDeroulant()
    {
        this.addItem(Listing.Liste);
        this.addItem(Listing.Semaine);
        this.addItem(Listing.Mois);

        ActionListener actionListener = new ActionListener()
        {

            @Override
            public void actionPerformed(ActionEvent actionEvent)
            {
                MenuDeroulant mr = (MenuDeroulant) (actionEvent.getSource());

                TaskPanel lp = MainWindow.getInstance().getMainPanel()
                        .getTaskPanel();

                PanneauList tablist = lp.getPanneauList();
                tablist.setVisible(false);

                PanneauSemaine tabsemaine = lp.getPanneauSemaine();
                tabsemaine.setVisible(false);

                PanneauMois tabmois = lp.getPanneauMois();
                tabmois.setVisible(false);

                if ("Liste".equals(mr.getSelectedItem().toString()))
                {
                    tablist.setVisible(true);
                }

                if ("Semaine".equals(mr.getSelectedItem().toString()))
                {
                    tabsemaine.setVisible(true);
                }
                
                if ("Mois".equals(mr.getSelectedItem().toString()))
                {
                    tabmois.setVisible(true);
                }

                lp.revalidate();
                lp.repaint();
            }
        };

        this.addActionListener(actionListener);
    }
}
