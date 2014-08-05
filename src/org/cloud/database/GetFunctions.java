package org.cloud.database;

import org.cloud.dto.FieldTypeDTO;

import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * Created by reza on 7/24/14.
 */
public class GetFunctions extends ConnectToDataBase{

    public ResultSet personInfoResult=null;
    public ArrayList functionListArray=new ArrayList();

    public ArrayList GetFunctionsDetail()
    {
        try {

            preparedStatement=connection.prepareStatement("select FUNCNAME,FUNCPROTOTYPE,ARGNUM,FIELDTYPE,DESCRIPTION from FUNCTIONS");
            personInfoResult=preparedStatement.executeQuery();
            connection.commit();

            FieldTypeDTO sectionType=new FieldTypeDTO();
            try {
                while (personInfoResult.next()) {

                    sectionType.funcName= personInfoResult.getString(1);
                    sectionType.funcPrototype=personInfoResult.getString(2);
                    sectionType.argNum= Integer.valueOf(personInfoResult.getString(3));
                    sectionType.fieldType= personInfoResult.getString(4);
                    sectionType.description=personInfoResult.getString(5);
                    //System.out.println(sectionType.toString());
                    functionListArray.add(sectionType);
                }
            } catch (Exception e){
                System.out.println("hi man");
            }

        }catch (Exception e)
        {
            System.out.println("in getFunctions : "+e.getMessage());
        }

        //functionListArray.add("hamidreza");
        return functionListArray;
    }
}
