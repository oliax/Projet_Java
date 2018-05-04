package com.itii.planning.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.itii.planning.gui.*;

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
        // Chargement du Driver. Stockage des données dans le fichier
        // planning.db
        connection = DriverManager
                .getConnection("jdbc:sqlite:database/planning.db");
        // Objet permettant l'exécution des requêtes SQL
        statement = connection.createStatement();
        // Timeout en cas de non-réponse de la base de données.
        statement.setQueryTimeout(15);
        } catch (SQLException e)
        {
            System.out.println(" Table non créée ou déjà existante");
            e.printStackTrace();
        }
        
        try
        {
            TaskDialog lp = MainWindow.getInstance().getMainPanel()
                    .getTaskPanel().getPanneauList().getTaskDialog(title);

            PreparedStatement stmt = connection.prepareStatement(
                    "insert into " + TABLE_NAME + " ( " + FIELD_NAME + ","
                            + FIELD_DATE + "," + FIELD_DETAILS + ","
                            + FIELD_STATE + " ) " + "values ( ?, ?, ?, ?) ");
            stmt.setString(1, lp.getName());
            stmt.setString(2, lp.getDate());
            stmt.setString(3, lp.getDetails());
            stmt.setString(4, "0");
            stmt.executeUpdate();
            System.out.println("insertion d'une nouvelle entrée dans la table");
        } catch (SQLException e)
        {
            System.out.println(
                    "problème dans l'insertion d'une nouvelle enrée dans la table.");
        }
        {
            try
            {
                if (connection != null)
                {
                    connection.close();
                }
                System.out.println(
                        "fermeture de la connection à la base de données");
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
        // Chargement du Driver. Stockage des données dans le fichier
        // planning.db
        connection = DriverManager
                .getConnection("jdbc:sqlite:database/planning.db");
        // Objet permettant l'exécution des requêtes SQL
        statement = connection.createStatement();
        // Timeout en cas de non-réponse de la base de données.
        statement.setQueryTimeout(15);
        } catch (SQLException e)
        {
            System.out.println(" Table non créée ou déjà existante");
            e.printStackTrace();
        }

        try
        {
            ResultSet rs = statement
                    .executeQuery("select * from " + TABLE_NAME);
            while (rs.next())
            {
                System.out.print("lecture d'une donnée [");
                System.out.print(" id = " + rs.getString(FIELD_ID));
                System.out.print(" ; name = " + rs.getString(FIELD_NAME));
                System.out.print(" ; date = " + rs.getString(FIELD_DATE));
                System.out.print(" ; details = " + rs.getString(FIELD_DETAILS));
                System.out.println(
                        " ; etat = " + rs.getString(FIELD_STATE) + "]");
            }
        } catch (SQLException e)
        {
            System.out.println("erreur à la lecture de la table");
        }
    }
    
    public static void readData()
    {
        Connection connection = null;
        Statement statement = null;;
        
//        TaskDialog lp = MainWindow.getInstance().getMainPanel()
//                .getTaskPanel().getPanneauList();
        
        try
        {
        // Chargement du Driver. Stockage des données dans le fichier
        // planning.db
        connection = DriverManager
                .getConnection("jdbc:sqlite:database/planning.db");
        // Objet permettant l'exécution des requêtes SQL
        statement = connection.createStatement();
        // Timeout en cas de non-réponse de la base de données.
        statement.setQueryTimeout(15);
        } catch (SQLException e)
        {
            System.out.println(" Table non créée ou déjà existante");
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
//                ((DefaultTableModel) lp.taskList.getModel()).addRow( new Object[] { name,date,detail});
            }
        } catch (SQLException e)
        {
            System.out.println("erreur à la lecture de la table");
        }
    }

    public void eraseData()
    {
        Connection connection = null;
        Statement statement = null;
        try
        {
            // Chargement du Driver. Stockage des données dans le fichier
            // planning.db
            connection = DriverManager
                    .getConnection("jdbc:sqlite:database/planning.db");
            // Objet permettant l'exécution des requêtes SQL
            statement = connection.createStatement();
            // Timeout en cas de non-réponse de la base de données.
            statement.setQueryTimeout(15);
            statement.execute("drop table if not exists " + TABLE_NAME);
            // Création de la table
            statement.executeUpdate("create table " + TABLE_NAME + " ( "
                    + FIELD_ID + " integer primary key autoincrement, " // Primary
                                                                        // key
                    + FIELD_NAME + " string, " // Name
                    + FIELD_DATE + " text, " // Details
                    + FIELD_DETAILS + " text, " // date as ISO8601 strings
                                                // ("YYYY-MM-DD HH:MM:SS.SSS").
                    + FIELD_STATE + " boolean " + " )"); // marquée
            System.out.println("table \"" + TABLE_NAME + "\" créée ");
        } catch (SQLException e)
        {
            System.out.println(" Table non créée ou déjà existante");
            e.printStackTrace();
        }
    }
    
    public static void copyData(String arg[])
    {
        Connection connection = null;
        Statement statement = null;
        
        try
        {
        // Chargement du Driver. Stockage des données dans le fichier
        // planning.db
        connection = DriverManager
                .getConnection("jdbc:sqlite:database/planning.db");
        // Objet permettant l'exécution des requêtes SQL
        statement = connection.createStatement();
        // Timeout en cas de non-réponse de la base de données.
        statement.setQueryTimeout(15);
        } catch (SQLException e)
        {
            System.out.println(" Table non créée ou déjà existante");
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
            stmt.setString(4, "0");
            stmt.executeUpdate();
            System.out.println("insertion d'une nouvelle entrée dans la table");
        } catch (SQLException e)
        {
            System.out.println(
                    "problème dans l'insertion d'une nouvelle enrée dans la table.");
        }
        {
            try
            {
                if (connection != null)
                {
                    connection.close();
                }
                System.out.println(
                        "fermeture de la connection à la base de données");
            } catch (SQLException e)
            {
                System.out.println(
                        "erreur lors de la fermeture de la connection");
            }
        }
    }


}
