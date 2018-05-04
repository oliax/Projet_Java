package com.itii.planning.gui;

import java.awt.BorderLayout;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.itii.planning.database.Database;

public class PanneauList extends TaskManager
{
    public static JTable taskList;
    TaskDialog dialog;
    
    public void addTask(String arg[])
    {
        ((DefaultTableModel) taskList.getModel()).addRow( new Object[] { arg[0],arg[1],arg[2]});
        Database.copyData(arg);
        Database.screenData();
    }
    
    public void addTask()
    {
      getTaskDialog("Nouvelle tache");        
    }
    
    public TaskDialog getTaskDialog(String title)
    {
        if(dialog==null)
        {
            dialog = new TaskDialog(title);
        }
        return dialog;
    }
    
    public void delTask()
    {     
       ((DefaultTableModel) taskList.getModel()).removeRow(taskList.getSelectedRow());
    }   
    
    public void copyTask()
    {
        int i=0;
        String arg[] = new String[taskList.getColumnCount()];
       
        for(i=0;i!=taskList.getColumnCount();i++)
        {
           arg[i]=""+(taskList.getValueAt(taskList.getSelectedRow(), i));
        }
        
        addTask(arg);
    }
    
    public void editTask()
    {
        int i=0;
        String arg[] = new String[taskList.getColumnCount()];
       
        for(i=0;i!=taskList.getColumnCount();i++)
        {
           arg[i]=""+(taskList.getValueAt(taskList.getSelectedRow(), i));
        }
        getTaskDialog("Edition de tache");
        dialog = new TaskDialog(arg[0],arg[1],arg[2]);
        
    }
    
    public PanneauList()
    {
        String title[]= {"Nom de la tâche", "Date due", "Détails"};
        DefaultTableModel tableModel = new DefaultTableModel(title, 0);
        taskList = new JTable(tableModel);
        
        /* Lecture de la BDD pour remplir le tableau en cours de réalisation */
//        Database.readData();
//        ((DefaultTableModel) taskList.getModel()).addRow( new Object[] { Database.name,Database.date,Database.detail});
        
        this.setLayout(new BorderLayout());
        this.add(new JScrollPane(taskList)); 
    }
}