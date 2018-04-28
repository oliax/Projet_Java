package com.itii.planning.gui;

import javax.swing.JFrame;

public class MainWindow extends JFrame
{
    private static MainWindow instance = new MainWindow();
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
    
    private MainWindow() 
    {
        setSize(500, 300);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.validate();
        this.repaint();
        
       MainPanel mainpanel = new MainPanel();
       getContentPane().add(mainpanel);

       MenuBar menubar = new MenuBar();
       setJMenuBar(menubar);
        
    }
}
