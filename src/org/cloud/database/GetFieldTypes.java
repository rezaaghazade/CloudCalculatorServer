package org.cloud.database;

import org.cloud.connectToDatabase.ConnectToDataBase;

import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * Created by reza on 8/5/14.
 */
public class GetFieldTypes extends ConnectToDataBase {

    public ResultSet result=null;
    public ArrayList resultArray=new ArrayList<ResultSet>();

    public ArrayList getFieldTypes()
    {

        try {

            preparedStatement=connection.prepareStatement("select FIELDTYPE from finalProject.FUNCTIONS");
            result=preparedStatement.executeQuery();
            connection.commit();

            while (result.next())
            {
                resultArray.add(result.getString(1));
            }

        }catch (Exception e)
        {
            System.out.println("in GetFieldTypes : "+e.getMessage());
        }
        return resultArray;
    }
}
