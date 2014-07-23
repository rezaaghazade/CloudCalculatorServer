package org.cloud.server;



import java.sql.*;
import java.util.ArrayList;

/**
 * Created by reza on 7/23/14.
 */
public class ConnectToDataBase {

    public PreparedStatement preparedStatement;
    public Connection connection;
    public ResultSet personInfoResult=null;
    public ArrayList personalArray=new ArrayList<ResultSet>();

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

    public ArrayList authenticity(String id,String passwd)
    {

        System.out.println("Id is : "+id);
        System.out.println("passwd is : "+passwd);


        try {

            preparedStatement=connection.prepareStatement("select TYPE,NAME,FAMILY from USERS where ID=? && PASSWD=?");
            preparedStatement.setString(1,id);
            preparedStatement.setString(2,passwd);
            personInfoResult=preparedStatement.executeQuery();
            connection.commit();

            if (personInfoResult.next())
            {
                personalArray.add(personInfoResult.getString(1));
                personalArray.add(personInfoResult.getString(2));
                personalArray.add(personInfoResult.getString(3));
            }

        }catch (Exception e)
        {
            System.out.println("in authenticity : "+e.getMessage());
        }
            return personalArray;
    }

}

