package org.cloud.database;

import domain.FieldTypeDTO;
import domain.Users;
import org.cloud.connectToDatabase.ConnectToDataBase;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * Created by reza on 8/10/14.
 */
public class GetUsersList extends ConnectToDataBase {
    public ResultSet personInfoResult=null;
    public ArrayList<Users> userListArray=new ArrayList<Users>();

    public ArrayList<Users> UsersList()
    {
        try {

            preparedStatement=connection.prepareStatement("select ID,TYPE,NAME,FAMILY from finalProject.USERS");
            personInfoResult=preparedStatement.executeQuery();
            connection.commit();

            try {
                while (personInfoResult.next()) {
                    Users us=new Users();
                    us.setID(personInfoResult.getString(1));
                    us.setType(personInfoResult.getInt(2));
                    us.setName(personInfoResult.getString(3));
                    us.setFamily(personInfoResult.getString(4));
                    userListArray.add(us);
                    us=null;
                }
            } catch (Exception e){
                System.out.println("hi man");
            }

        }catch (Exception e)
        {
            System.out.println("in getFunctions : "+e.getMessage());
        }
        return userListArray;
    }
}
