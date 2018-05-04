package com.itii.planning.gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import org.jdatepicker.JDatePicker;
import org.jdatepicker.UtilDateModel;

import com.itii.planning.database.Database;

public class TaskDialog extends JDialog
{
    private JDatePicker calendar;
    private JDialog dialog = new JDialog();
    JLabel tasklabel = new JLabel("Nom de la tache :   ");
    JLabel datelabel = new JLabel("Date due :");
    JLabel detaillabel = new JLabel("Details :");
    JTextField taskname = new JTextField(40);
    JTextField detailname = new JTextField(30);
    JButton OKButton = new JButton("OK");
    JButton CancelButton = new JButton("Annuler");
    
    public TaskDialog (String title)
    {
        this.setTitle(title);
        this.setSize(600, 300);
        
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        this.add(tasklabel, gbc);
        gbc.gridx = 1;
        this.add(taskname, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        this.add(datelabel, gbc);
        gbc.gridx = 1;
        this.add(getCalendar(),gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weighty = 0;
        this.add(detaillabel, gbc);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 1;
        gbc.weighty = 1;
        this.add(detailname,gbc);
       
        
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 3;
        this.add(OKButton,gbc);
        gbc.gridx = 1;
        this.add(CancelButton,gbc);
        
        ActionListener actionListener = new ActionListener()
        {

            @Override
            public void actionPerformed(ActionEvent actionEvent)
            {
                JButton mr = (JButton) (actionEvent.getSource());

                TaskPanel lp = MainWindow.getInstance().getMainPanel()
                        .getTaskPanel();

                PanneauList tablist = lp.getPanneauList();

                if (mr==OKButton)
                {
                    Database.writeData(title);
                    Database.screenData();
                    ((DefaultTableModel) tablist.taskList.getModel()).addRow( new Object[] { getName(),getDate(),getDetails()});
                    tablist.dialog.dispose();
                    tablist.dialog = null;
                    
                    
                }
                if (mr==CancelButton)
                {
                    tablist.dialog.dispose();
                    tablist.dialog = null;
                }

            }
        };
        
        OKButton.addActionListener(actionListener);
        CancelButton.addActionListener(actionListener);
        
        this.setVisible(true);
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

    }
    
    
    public TaskDialog (String arg1, String arg2, String arg3)
    {
        this.taskname.setText(arg1);
        System.out.println(this.taskname + "OK");
        this.setDate(arg2);
        this.detailname.setText(arg3);
    }
    
    
    
    
    // Accesseur sur notre calendrier
    public JDatePicker getCalendar()
    {
        if (calendar == null)
        {
            UtilDateModel model = new UtilDateModel();
            Calendar cal = Calendar.getInstance();
            model.setDate(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH),
            cal.get(Calendar.DAY_OF_WEEK));
            calendar = new JDatePicker(model);
        }
        return calendar;
    }

    // Accesseur mettant � jour la date affich�e
    public void setDate(String date)
    {
        getCalendar().getFormattedTextField().setText(date);
    }
    
    // Accesseur r�cup�rant la date actuellement affich�e
    public String getDate()
    {
        return getCalendar().getFormattedTextField().getText();
    }
    
    // Accesseur r�cup�rant le nom
    public String getName()
    {
        return taskname.getText();
    }
    
    // Accesseur r�cup�rant le nom
    public String getDetails()
    {
        return detailname.getText();
    }
}