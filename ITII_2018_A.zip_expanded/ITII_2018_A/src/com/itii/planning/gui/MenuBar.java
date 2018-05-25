package com.itii.planning.gui;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class MenuBar extends JMenuBar 
{
    private JMenu fichier = new JMenu("Fichier");
    private JMenu edition = new JMenu("Edition");
    private JMenu vue = new JMenu("Vue");
    
    private JMenuItem aide = new JMenuItem("Aide");
    private JMenuItem quitter = new JMenuItem("Quitter");
    private JMenuItem creer = new JMenuItem("Creer");
    private JMenuItem editer = new JMenuItem("Editer");
    private JMenuItem marquer = new JMenuItem("Marquer");
    private JMenuItem dupliquer = new JMenuItem("Dupliquer");
    private JMenuItem supprimer = new JMenuItem("Supprimer");
    private JMenuItem liste = new JMenuItem("Liste");
    private JMenuItem semaine = new JMenuItem("Semaine");
    private JMenuItem mois = new JMenuItem("Mois");
    
    public MenuBar()
    {
        this.add(fichier);
        this.add(edition);
        this.add(vue);
        this.add(aide);
        
        this.fichier.add(quitter);

        this.edition.add(creer);
        this.edition.add(editer);
        this.edition.add(marquer);
        this.edition.add(dupliquer);
        this.edition.add(supprimer);
        
        this.vue.add(liste);
        this.vue.add(semaine);
        this.vue.add(mois);
        
        ActionListener actionListener = new ActionListener()
        {

            @Override
            public void actionPerformed(ActionEvent actionEvent)
            {
                JMenuItem mr = (JMenuItem) (actionEvent.getSource());

                TaskPanel lp = MainWindow.getInstance().getMainPanel()
                        .getTaskPanel();

                PanneauList tablist = lp.getPanneauList();

                PanneauSemaine tabsemaine = lp.getPanneauSemaine();

                PanneauMois tabmois = lp.getPanneauMois();
                
                MenuDeroulant menu = MainWindow.getInstance().getMainPanel().getHeaderPanel().menu_list;

                if (mr==creer)
                {
                    tablist.addTask();
                }

                if (mr==editer)
                {
                    tablist.editTask();
                }
                
                if (mr==marquer)
                {
                    JOptionPane.showMessageDialog(null, "Fonction non développée", "Développement en cours...", JOptionPane.INFORMATION_MESSAGE);  
                }
                
                if (mr==dupliquer)
                {
                    tablist.copyTask();
                }
                
                if (mr==supprimer)
                {
                    tablist.delTask();
                }
                
                if(mr==quitter)
                {
                    MainWindow.getInstance().dispose();
                }
                
                if(mr==liste)
                {
                    menu.setSelectedItem(Listing.Liste);
                }
                
                if(mr==semaine)
                {
                    menu.setSelectedItem(Listing.Semaine);
                }
                
                if(mr==mois)
                {
                    menu.setSelectedItem(Listing.Mois);
                }
                
                if(mr==aide)
                {
                    JOptionPane.showMessageDialog(null, "Pour Créer une ligne, appuyez sur créer, puis après modification appuyez sur ok"
                            + "\n"
                            + "Pour Editer une ligne, appuyez sur éditer, puis après modification appuyez sur ok"
                            + "\n"
                            + "Pour Dupliquer une ligne, sélectionnez la ligne désirée puis appuyez sur dupliquer"
                            + "\n"
                            + "Pour Supprimer une ligne, sélectionnez la ligne désirée puis appuyez sur supprimer"
                            , "Aide", JOptionPane.INFORMATION_MESSAGE);                         
                }
               
                lp.revalidate();
                lp.repaint();
            }
        };

        creer.addActionListener(actionListener);
        editer.addActionListener(actionListener);
        marquer.addActionListener(actionListener);
        dupliquer.addActionListener(actionListener);
        supprimer.addActionListener(actionListener);
        quitter.addActionListener(actionListener);
        aide.addActionListener(actionListener);
        liste.addActionListener(actionListener);
        semaine.addActionListener(actionListener);
        mois.addActionListener(actionListener);
    }
}
