package org.cloud.server;

import java.io.Serializable;
import java.sql.*;

/**
 * Created by reza on 7/23/14.
 */
public class ConnectToDataBase{

    public static Connection connection;
    public static PreparedStatement preparedStatement;

    public ConnectToDataBase()
    {
        try {

            Class.forName("com.mysql.jdbc.Driver");
            connection= DriverManager.getConnection("jdbc:mysql://localhost/finalProject", "root", "1210");
            connection.setAutoCommit(false);

        }catch (Exception e)
        {
            System.out.println("Constructor : "+e.getMessage());
        }
    }


}

