package org.cloud.database;

import org.cloud.connectToDatabase.ConnectToDataBase;

import java.sql.ResultSet;

/**
 * Created by reza on 8/7/14.
 */
public class CheckForUniqueUser extends ConnectToDataBase {

    public ResultSet personInfoResult=null;

    public boolean userUniqueCheck(String userName)
    {
        try {
            preparedStatement=connection.prepareStatement("select TYPE from finalProject.USERS where ID=?");
            preparedStatement.setString(1, userName);
            personInfoResult=preparedStatement.executeQuery();
            connection.commit();

            //false means new user is EXIST
            if (personInfoResult.next())
                return false;
            else
                return true;


        }catch (Exception e)
        {
            System.out.println("check User in CheckForUniqueUser : "+e.getMessage());
            return false;

        }
    }
}
