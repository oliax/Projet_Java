package com.itii.planning.gui;

import java.awt.BorderLayout;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.itii.planning.database.Database;

import javafx.scene.control.TableColumn;

public class PanneauList extends TaskManager
{
    public static JTable taskList;
    TaskDialog dialog;
    
    public void addTask(String arg[])
    {
        ((DefaultTableModel) taskList.getModel()).addRow( new Object[] { arg[0],arg[1],arg[2],arg[3],arg[4]});
        
        
        // On récupère l'ID de la nouvelle ligne de la BDD pour mettre à jour le champ de la JTable
        String id=Database.copyData(arg);
            
        taskList.setValueAt(id, (taskList.getRowCount()-1), 3);
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
        Database.eraseData((taskList.getValueAt(taskList.getSelectedRow(), 3)));
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
              
        TaskDialog dialog = getTaskDialog("Edition de tache");
        
        dialog.taskname.setText(arg[0]);
        dialog.setDate(arg[1]);
        dialog.detailname.setText(arg[2]);
        dialog.ID=(taskList.getValueAt(taskList.getSelectedRow(), 3));
    }
    
    public PanneauList()
    {
        String title[]= {"Nom de la tâche", "Date due", "Détails","ID","Etat"};
        DefaultTableModel tableModel = new DefaultTableModel(title, 0)
        {
            @Override
            public boolean isCellEditable(int row, int column)
            {
                return false;
            }
        };
       
        taskList = new JTable(tableModel);
              
        Database.readData(taskList);
        
        // On masque les colonnes qui ne sont pas utile pour l'utilisateur
        {
          taskList.getColumnModel().getColumn(4).setMaxWidth(0);
          taskList.getColumnModel().getColumn(4).setMinWidth(0);
          taskList.getColumnModel().getColumn(4).setPreferredWidth(0);
          taskList.getColumnModel().getColumn(3).setMaxWidth(0);
          taskList.getColumnModel().getColumn(3).setMinWidth(0);
          taskList.getColumnModel().getColumn(3).setPreferredWidth(0);
        }
        
        this.setLayout(new BorderLayout());
        this.add(new JScrollPane(taskList)); 
    }
}