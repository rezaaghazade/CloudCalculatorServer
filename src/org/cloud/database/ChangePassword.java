package org.cloud.database;

import org.cloud.connectToDatabase.ConnectToDataBase;

/**
 * Created by reza on 8/7/14.
 */
public class ChangePassword extends ConnectToDataBase {

    public boolean changePasswd(String id,String passwd)
    {
        try {
            preparedStatement=connection.prepareStatement("update finalProject.USERS set PASSWD=? where ID=?");
            preparedStatement.setString(1, passwd);
            preparedStatement.setString(2, id);
            preparedStatement.execute();
            connection.commit();
            return true;

        }catch (Exception e)
        {
            System.out.println("Change Password.Server : "+e.getMessage());
            return false;
        }
    }
}
