package org.cloud.database;

/**
 * Created by reza on 8/4/14.
 */
public class AddUser extends ConnectToDataBase {

    public boolean PushUser(String id,String passwd,Integer type,String name,String family)
    {
        try {
            preparedStatement=connection.prepareStatement("insert into finalProject.USERS (ID,TYPE,PASSWD,NAME,FAMILY) values (?,?,?,?,?)");
            preparedStatement.setString(1, id);
            preparedStatement.setInt(2, type);
            preparedStatement.setString(3, passwd);
            preparedStatement.setString(4,name);
            preparedStatement.setString(5,family);
            preparedStatement.execute();
            //preparedStatement.executeQuery();
            connection.commit();
            return true;

        }catch (Exception e)
        {
            System.out.println("Push User.Server : "+e.getMessage());
            return false;

    }
    }
}
