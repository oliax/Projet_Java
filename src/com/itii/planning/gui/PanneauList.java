package com.itii.planning.gui;

import java.awt.BorderLayout;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class PanneauList extends TaskManager
{
    private static JTable taskList;
    
    public void addTask(String arg[])
    {
        ((DefaultTableModel) taskList.getModel()).addRow( new Object[] { arg[0],arg[1],arg[2]});
    }
    
    public void addTask()
    {
      TaskDialog calendar = new TaskDialog();
        ((DefaultTableModel) taskList.getModel()).addRow( new Object[] {"",/*this.add(calendar.getCalendar()),*/""});
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
    }
    
    public PanneauList()
    {
        String title[]= {"Nom de la tâche", "Date due", "Détails"};
        DefaultTableModel tableModel = new DefaultTableModel(title, 0);
        taskList = new JTable(tableModel);

        ((DefaultTableModel) taskList.getModel()).addRow( new Object[] { "Terminer le TP",
                                                                             "2018/05/05 20:20",
                                                                             "Pour avoir une super note!"});
        
        this.setLayout(new BorderLayout());
        this.add(new JScrollPane(taskList)); 
        addTask();
    }
}