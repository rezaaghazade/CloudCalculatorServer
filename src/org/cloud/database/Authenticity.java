package org.cloud.database;

import org.cloud.connectToDatabase.ConnectToDataBase;

import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * Created by reza on 7/24/14.
 */
public class Authenticity extends ConnectToDataBase {

    public ResultSet personInfoResult=null;
    public ArrayList personalArray=new ArrayList<ResultSet>();

    public ArrayList Authenticity(String id,String passwd)
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
                personalArray.add(personInfoResult.getInt( 1));
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
