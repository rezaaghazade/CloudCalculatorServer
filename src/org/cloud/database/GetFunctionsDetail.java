package org.cloud.database;

import domain.Function;
import org.cloud.connectToDatabase.ConnectToDataBase;

import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * Created by reza on 7/24/14.
 */
public class GetFunctionsDetail extends ConnectToDataBase {

    public ResultSet personInfoResult=null;
    public ArrayList<Function> functionListArray=new ArrayList<Function>();

    public ArrayList<Function> GetDetail()
    {
        try {

            preparedStatement=connection.prepareStatement("select FUNCNAME,FUNCPROTOTYPE,ARGNUM,FIELDTYPE,DESCRIPTION from finalProject.FUNCTIONS");
            personInfoResult=preparedStatement.executeQuery();
            connection.commit();


            try {
                while (personInfoResult.next()) {
                    Function func=new Function();
                    func.funcName= personInfoResult.getString(1);
                    func.funcPrototype=personInfoResult.getString(2);
                    func.argNum= Integer.valueOf(personInfoResult.getString(3));
                    func.fieldType= personInfoResult.getString(4);
                    func.description=personInfoResult.getString(5);
                    //System.out.println(func.toString());
                    functionListArray.add(func);
                    func=null;
                }
            } catch (Exception e){
                System.out.println("hi man");
            }

        }catch (Exception e)
        {
            System.out.println("in getFunctions : "+e.getMessage());
        }

        System.out.println(functionListArray.size());
        return functionListArray;
    }
}
