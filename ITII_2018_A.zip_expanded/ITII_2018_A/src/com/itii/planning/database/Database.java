package com.itii.planning.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.itii.planning.gui.MainWindow;
import com.itii.planning.gui.TaskDialog;

public class Database
{
    private static final String TABLE_NAME = "Tasks";
    private static final String FIELD_ID = "id";
    private static final String FIELD_NAME = "name";
    private static final String FIELD_DATE = "date";
    private static final String FIELD_DETAILS = "details";
    private static final String FIELD_STATE = "state";
    
    public static String ID;
    public static String name;
    public static String date;
    public static String detail;
    public static String etat;

    public static void writeData(String title)
    {
  
        Connection connection = null;
        Statement statement = null;
        
        try
        {
        // Chargement du Driver. Stockage des donn�es dans le fichier
        // planning.db
        connection = DriverManager
                .getConnection("jdbc:sqlite:database/planning.db");
        // Objet permettant l'ex�cution des requ�tes SQL
        statement = connection.createStatement();
        // Timeout en cas de non-r�ponse de la base de donn�es.
        statement.setQueryTimeout(15);
        } catch (SQLException e)
        {
            System.out.println(" Table non cr��e ou d�j� existante");
            e.printStackTrace();
        }
        
        try
        {

            TaskDialog lp = MainWindow.getInstance().getMainPanel()
                    .getTaskPanel().getPanneauList().getTaskDialog(title);
            
            if(title.equals("Edition de tache"))
            {
                PreparedStatement updt = connection.prepareStatement(
                        "update " + TABLE_NAME + " set " + FIELD_NAME + " = ?, "
                                + FIELD_DATE + " = ?, " + FIELD_DETAILS + " = ?, " + FIELD_STATE + " = ? where " + FIELD_ID + "= ?");
                                                    
                updt.setString(1, lp.getName());
                updt.setString(2, lp.getDate());
                updt.setString(3, lp.getDetails());
                updt.setString(4, "0");
                updt.setString(5, (String) lp.ID);
                updt.executeUpdate();
            }
            else
            {
                PreparedStatement stmt = connection.prepareStatement(
                        "insert into " + TABLE_NAME + " ( " + FIELD_NAME + ","
                                + FIELD_DATE + "," + FIELD_DETAILS + ","
                                + FIELD_STATE + " ) " + "values ( ?, ?, ?, ?) ");
                
                stmt.setString(1, lp.getName());
                stmt.setString(2, lp.getDate());
                stmt.setString(3, lp.getDetails());
                stmt.setString(4, "0");
                stmt.executeUpdate();
                System.out.println("insertion d'une nouvelle entr�e dans la table");
            }
        } catch (SQLException e)
        {
            System.out.println(
                    "probl�me dans l'insertion d'une nouvelle entr�e dans la table.");
        }
        {
            try
            {
                if (connection != null)
                {
                    connection.close();
                }
                System.out.println(
                        "fermeture de la connection � la base de donn�es");
            } catch (SQLException e)
            {
                System.out.println(
                        "erreur lors de la fermeture de la connection");
            }
        }
    }
    
    public static void eraseData(Object i)
    {
  
        Connection connection = null;
        Statement statement = null;
        
        try
        {
        // Chargement du Driver. Stockage des donn�es dans le fichier
        // planning.db
        connection = DriverManager
                .getConnection("jdbc:sqlite:database/planning.db");
        // Objet permettant l'ex�cution des requ�tes SQL
        statement = connection.createStatement();
        // Timeout en cas de non-r�ponse de la base de donn�es.
        statement.setQueryTimeout(15);
        } catch (SQLException e)
        {
            System.out.println(" Table non cr��e ou d�j� existante");
            e.printStackTrace();
        }
        
        try
        {
            PreparedStatement dlt = connection.prepareStatement(
                    "delete from "+ TABLE_NAME +" where " + FIELD_ID + " = " + i);                           
            
            dlt.executeUpdate();
            
        } catch (SQLException e)
        {
            System.out.println(
                    "probl�me dans la suppression d'une donn�e dans la table.");
        }
        {
            try
            {
                if (connection != null)
                {
                    connection.close();
                }
                System.out.println(
                        "fermeture de la connection � la base de donn�es");
            } catch (SQLException e)
            {
                System.out.println(
                        "erreur lors de la fermeture de la connection");
            }
        }
    }

    public static void screenData()
    {
        Connection connection = null;
        Statement statement = null;;

        try
        {
        // Chargement du Driver. Stockage des donn�es dans le fichier
        // planning.db
        connection = DriverManager
                .getConnection("jdbc:sqlite:database/planning.db");
        // Objet permettant l'ex�cution des requ�tes SQL
        statement = connection.createStatement();
        // Timeout en cas de non-r�ponse de la base de donn�es.
        statement.setQueryTimeout(15);
        } catch (SQLException e)
        {
            System.out.println(" Table non cr��e ou d�j� existante");
            e.printStackTrace();
        }

        try
        {
            ResultSet rs = statement
                    .executeQuery("select * from " + TABLE_NAME);
            while (rs.next())
            {
                System.out.print("lecture d'une donn�e [");
                System.out.print(" id = " + rs.getString(FIELD_ID));
                System.out.print(" ; name = " + rs.getString(FIELD_NAME));
                System.out.print(" ; date = " + rs.getString(FIELD_DATE));
                System.out.print(" ; details = " + rs.getString(FIELD_DETAILS));
                System.out.println(
                        " ; etat = " + rs.getString(FIELD_STATE) + "]");
            }
        } catch (SQLException e)
        {
            System.out.println("erreur � la lecture de la table");
        }
    }
    
    public static void readData(JTable tasklist)
    {
        Connection connection = null;
        Statement statement = null;;
        
        try
        {
        // Chargement du Driver. Stockage des donn�es dans le fichier
        // planning.db
        connection = DriverManager
                .getConnection("jdbc:sqlite:database/planning.db");
        // Objet permettant l'ex�cution des requ�tes SQL
        statement = connection.createStatement();
        // Timeout en cas de non-r�ponse de la base de donn�es.
        statement.setQueryTimeout(15);
        } catch (SQLException e)
        {
            System.out.println(" Table non cr��e ou d�j� existante");
            e.printStackTrace();
        }

        try
        {
            ResultSet rs = statement
                    .executeQuery("select * from " + TABLE_NAME);
            while (rs.next())
            {
                ID=rs.getString(FIELD_ID);
                name=rs.getString(FIELD_NAME);
                date=rs.getString(FIELD_DATE);
                detail=rs.getString(FIELD_DETAILS);
                etat=rs.getString(FIELD_STATE);
                
                ((DefaultTableModel) tasklist.getModel()).addRow( new Object[] { name,date,detail,ID,etat});
            }
        } catch (SQLException e)
        {
            System.out.println("erreur � la lecture de la table");
        }
    }
    
    public static String copyData(String arg[])
    {
        Connection connection = null;
        Statement statement = null;
        String cpt = null;
        
        try
        {
        // Chargement du Driver. Stockage des donn�es dans le fichier
        // planning.db
        connection = DriverManager
                .getConnection("jdbc:sqlite:database/planning.db");
        // Objet permettant l'ex�cution des requ�tes SQL
        statement = connection.createStatement();
        // Timeout en cas de non-r�ponse de la base de donn�es.
        statement.setQueryTimeout(15);
        } catch (SQLException e)
        {
            System.out.println(" Table non cr��e ou d�j� existante");
            e.printStackTrace();
        }
        
        try
        {        
            PreparedStatement stmt = connection.prepareStatement(
                    "insert into " + TABLE_NAME + " ( " + FIELD_NAME + ","
                            + FIELD_DATE + "," + FIELD_DETAILS + ","
                            + FIELD_STATE + " ) " + "values ( ?, ?, ?, ?) ");
            stmt.setString(1, arg[0]);
            stmt.setString(2, arg[1]);
            stmt.setString(3, arg[2]);
            stmt.setString(4, arg[4]);
            stmt.executeUpdate();
                  
            ResultSet rs = statement
                    .executeQuery("select * from " + TABLE_NAME);
            while(rs.next())
            {
                cpt=rs.getString(FIELD_ID);
            }
            
            System.out.println("insertion d'une nouvelle entr�e dans la table");
        } catch (SQLException e)
        {
            System.out.println(
                    "probl�me dans l'insertion d'une nouvelle enr�e dans la table.");
        }
        {
            try
            {
                if (connection != null)
                {
                    connection.close();
                }
                System.out.println(
                        "fermeture de la connection � la base de donn�es");
            } catch (SQLException e)
            {
                System.out.println(
                        "erreur lors de la fermeture de la connection");
            }
        }
        
        return cpt;
    }
    
    public static String ID()
    {
        Connection connection = null;
        Statement statement = null;
        String cpt = null;

        
        try
        {
        // Chargement du Driver. Stockage des donn�es dans le fichier
        // planning.db
        connection = DriverManager
                .getConnection("jdbc:sqlite:database/planning.db");
        // Objet permettant l'ex�cution des requ�tes SQL
        statement = connection.createStatement();
        // Timeout en cas de non-r�ponse de la base de donn�es.
        statement.setQueryTimeout(15);
        } catch (SQLException e)
        {
            System.out.println(" Table non cr��e ou d�j� existante");
            e.printStackTrace();
        }
        
        try
        {                     
            ResultSet rs = statement
                    .executeQuery("select * from " + TABLE_NAME);
            while(rs.next())
            {
                cpt=rs.getString(FIELD_ID);
            }
            
        } catch (SQLException e)
        {
            System.out.println(
                    "probl�me dans la lecture de la table.");
        }
        {
            try
            {
                if (connection != null)
                {
                    connection.close();
                }
                System.out.println(
                        "fermeture de la connection � la base de donn�es");
            } catch (SQLException e)
            {
                System.out.println(
                        "erreur lors de la fermeture de la connection");
            }
        }
        
        return cpt;
    }


}
