package org.cloud.database;

import domain.History;
import domain.History;
import org.cloud.connectToDatabase.ConnectToDataBase;

import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * Created by reza on 8/10/14.
 */
public class GetHistory extends ConnectToDataBase {
    public ResultSet personInfoResult=null;
    public ArrayList<History> historyList=new ArrayList<History>();

    public ArrayList<History> GetHs()
    {
        try {

            preparedStatement=connection.prepareStatement("select ID,OPDATE,OPNAME from finalProject.HISTORY");

            personInfoResult=preparedStatement.executeQuery();
            connection.commit();

            try {
                while (personInfoResult.next()) {
                    
                    History hs=new History();

                    hs.setID(personInfoResult.getString(1));
                    hs.setOpDate(personInfoResult.getString(2));
                    hs.setOpName(personInfoResult.getString(3));
                    historyList.add(hs);
                    hs=null;
                }
            } catch (Exception e){
                System.out.println("hi man");
            }

        }catch (Exception e)
        {
            System.out.println("in getFunctions : "+e.getMessage());
        }

        System.out.println(historyList.size());
        return historyList;
    }

}
