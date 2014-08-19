package org.cloud.database;

import org.cloud.connectToDatabase.ConnectToDataBase;
import domain.FieldTypeDTO;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * Created by reza on 7/24/14.
 */
public class GetFunctionsDetail extends ConnectToDataBase {

    public ResultSet personInfoResult=null;
    public ArrayList<FieldTypeDTO> functionListArray=new ArrayList<FieldTypeDTO>();

    public ArrayList<FieldTypeDTO> GetDetail()
    {
        try {

            preparedStatement=connection.prepareStatement("select FUNCNAME,FUNCPROTOTYPE,ARGNUM,FIELDTYPE,DESCRIPTION from finalProject.FUNCTIONS");
            personInfoResult=preparedStatement.executeQuery();
            connection.commit();


            try {
                while (personInfoResult.next()) {
                    FieldTypeDTO fieldTypeDto=new FieldTypeDTO();
                    fieldTypeDto.funcName= personInfoResult.getString(1);
                    fieldTypeDto.funcPrototype=personInfoResult.getString(2);
                    fieldTypeDto.argNum= Integer.valueOf(personInfoResult.getString(3));
                    fieldTypeDto.fieldType= personInfoResult.getString(4);
                    fieldTypeDto.description=personInfoResult.getString(5);
                    //System.out.println(fieldTypeDto.toString());
                    functionListArray.add(fieldTypeDto);
                    fieldTypeDto=null;
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
