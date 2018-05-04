package com.itii.planning.gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ButtonPanel extends JPanel implements ActionListener
{
    JButton boutonCreer = new JButton("Creer");
    JButton boutonEditer = new JButton("Editer");
    JButton boutonMarquer = new JButton("Marquer");
    JButton boutonDupliquer = new JButton("Dupliquer");
    JButton boutonSupprimer = new JButton("Supprimer");
      
    public ButtonPanel()
    {
        this.setLayout(new GridLayout(5,1));
        this.add(boutonCreer);
        this.add(boutonEditer);
        this.add(boutonMarquer);
        this.add(boutonDupliquer);
        this.add(boutonSupprimer);
        
        ActionListener actionListener = new ActionListener()
        {

            @Override
            public void actionPerformed(ActionEvent actionEvent)
            {
                JButton mr = (JButton) (actionEvent.getSource());

                TaskPanel lp = MainWindow.getInstance().getMainPanel()
                        .getTaskPanel();

                PanneauList tablist = lp.getPanneauList();

                PanneauSemaine tabsemaine = lp.getPanneauSemaine();

                PanneauMois tabmois = lp.getPanneauMois();

                if (mr==boutonCreer)
                {
                    tablist.addTask();
                }

                if (mr==boutonEditer)
                {
                    tablist.editTask();
                }
                
                if (mr==boutonMarquer)
                {
                    System.out.println("Marquer");
                }
                
                if (mr==boutonDupliquer)
                {
                    tablist.copyTask();
                }
                
                if (mr==boutonSupprimer)
                {
                    tablist.delTask();
                }

                lp.revalidate();
                lp.repaint();
            }
        };

        boutonCreer.addActionListener(actionListener);
        boutonEditer.addActionListener(actionListener);
        boutonMarquer.addActionListener(actionListener);
        boutonDupliquer.addActionListener(actionListener);
        boutonSupprimer.addActionListener(actionListener);
    }

    @Override
    public void actionPerformed(ActionEvent arg0)
    {
        // TODO Auto-generated method stub
        
    }
}
