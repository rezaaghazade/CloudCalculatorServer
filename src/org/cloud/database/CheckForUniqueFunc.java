package org.cloud.database;

import org.cloud.connectToDatabase.ConnectToDataBase;

import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * Created by reza on 8/6/14.
 */
public class CheckForUniqueFunc extends ConnectToDataBase {

    public ResultSet personInfoResult=null;

    public boolean checkFunc(String funcName,String fieldType)
    {
        try {
            preparedStatement=connection.prepareStatement("select FUNCNAME from finalProject.FUNCTIONS where FIELDTYPE=? && FUNCNAME=?");
            preparedStatement.setString(1, fieldType);
            preparedStatement.setString(2, funcName);
            personInfoResult=preparedStatement.executeQuery();
            connection.commit();

            //false means new function is EXIST
            if (personInfoResult.next())
                return false;
            else
                return true;


        }catch (Exception e)
        {
            System.out.println("check Function in CheckForUniqueFunc : "+e.getMessage());
            return false;

        }
    }
}
