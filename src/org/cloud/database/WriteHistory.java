package org.cloud.database;

import org.cloud.connectToDatabase.ConnectToDataBase;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by reza on 8/6/14.
 */
public class WriteHistory extends ConnectToDataBase {

    public boolean PushOperationHistory(String opName,String id)
    {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        //System.out.println(dateFormat.format(date)); //2014/08/06 15:59:48

        try {
            preparedStatement=connection.prepareStatement("insert into finalProject.HISTORY (OPNAME,ID,OPDATE) values (?,?,?)");
            preparedStatement.setString(1, opName);
            preparedStatement.setString(2, id);
            preparedStatement.setString(3, dateFormat.format(date));
            preparedStatement.execute();
            connection.commit();
            return true;

        }catch (Exception e)
        {
            System.out.println("Push Operation.WriteHistory : "+e.getMessage());
            return false;

        }
    }
}
