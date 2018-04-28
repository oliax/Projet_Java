package com.itii.planning.gui;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuBar extends JMenuBar 
{
    private JMenu fichier = new JMenu("Fichier");
    private JMenu edition = new JMenu("Edition");
    private JMenu vue = new JMenu("Vue");
    private JMenu aide = new JMenu("Aide");
    
    private JMenuItem quitter = new JMenuItem("Quitter");
    private JMenuItem creer = new JMenuItem("Créer");
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

    }
}
