package org.cloud.database;

import org.cloud.connectToDatabase.ConnectToDataBase;

/**
 * Created by reza on 8/6/14.
 */
public class AddFunctionDetail extends ConnectToDataBase {

    public boolean PushFunctionDetail(String name,String prototype,String argnum,String fieldtype,String description)
    {
        try {
            preparedStatement=connection.prepareStatement("insert into finalProject.FUNCTIONS (FUNCNAME,FUNCPROTOTYPE,ARGNUM,FIELDTYPE,DESCRIPTION) values (?,?,?,?,?)");
            preparedStatement.setString(1,name);
            preparedStatement.setString(2, prototype);
            preparedStatement.setInt(3, Integer.valueOf(argnum));
            preparedStatement.setString(4,fieldtype);
            preparedStatement.setString(5,description);
            preparedStatement.execute();
            connection.commit();
            return true;

        }catch (Exception e)
        {
            System.out.println("Push Function.Detail : "+e.getMessage());
            return false;

        }
    }
}
