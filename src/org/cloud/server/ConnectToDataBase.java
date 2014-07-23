package org.cloud.server;



import java.sql.*;

/**
 * Created by reza on 7/23/14.
 */
public class ConnectToDataBase {

    public PreparedStatement preparedStatement;
    public Connection connection;
    public ResultSet personInfo=null;

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

    public void authenticity(String id,String passwd)
    {

        try {

            preparedStatement=connection.prepareStatement("select TYPE,NAME,FAMILY from USERS where ID=? && PASSWD=?");
            preparedStatement.setString(1,id);
            preparedStatement.setString(2,passwd);
            personInfo=preparedStatement.executeQuery();

            System.out.println("hi there");

            personInfo.next();
            System.out.println(personInfo.getString(1));
            System.out.println(personInfo.getString(2));
            System.out.println(personInfo.getString(3));

            System.out.println("after there");

        }catch (Exception e)
        {
            System.out.println("in authenticity : "+e.getMessage());
        }

    }

}

