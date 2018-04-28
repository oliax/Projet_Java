package com.itii.planning.gui;

import javax.swing.JFrame;

public class MainWindow extends JFrame
{
    private static MainWindow instance = new MainWindow();
    private MainPanel mpanel;
    public static Object syncObject = new Object();
    
    public static MainWindow getInstance()
    {
        if (instance == null)
        {
            synchronized(syncObject)
            {
                if (instance == null)
                {
                    instance = new MainWindow();
                }
            }
        }
        return instance;
    }
    
    public MainPanel getMainPanel()
    {
        if(mpanel==null)
        {
            mpanel = new MainPanel();
        }
        return mpanel;
    }
    
    private MainWindow() 
    {
        setTitle("Projet de Java - Planning");
        setSize(500, 300);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        getContentPane().add(getMainPanel());

       MenuBar menubar = new MenuBar();
       setJMenuBar(menubar);
       
       this.validate();
       this.repaint();
        
    }
}
