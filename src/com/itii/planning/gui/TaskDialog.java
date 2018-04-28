package com.itii.planning.gui.task;

import java.util.Calendar;

import javax.swing.JDialog;

import org.jdatepicker.JDatePicker;
import org.jdatepicker.UtilDateModel;

public class TaskDialog extends JDialog
{
    private JDatePicker calendar;
    
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

    // Accesseur mettant à jour la date affichée
    public void setDate(String date)
    {
    getCalendar().getFormattedTextField().setText(date);
    }
    
    // Accesseur récupérant la date actuellement affichée
    public String getDate()
    {
    return getCalendar().getFormattedTextField().getText();
    }
}