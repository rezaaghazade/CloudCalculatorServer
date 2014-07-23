package org.cloud.database;

import org.cloud.dto.SectionTypeDTO;

import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * Created by reza on 7/24/14.
 */
public class GetFunctions extends ConnectToDataBase{

    public ResultSet personInfoResult=null;
    public ArrayList<SectionTypeDTO> functionListArray=new ArrayList<SectionTypeDTO>();

    public ArrayList GetFunctionsDetail()
    {

        try {

            preparedStatement=connection.prepareStatement("select RETTYPE,FUNCNAME,ARGSTR,ARGNUM,SECTIONTYPE from FUNCTIONS");
            personInfoResult=preparedStatement.executeQuery();
            connection.commit();

            SectionTypeDTO sectionType=new SectionTypeDTO();
            try {
                while (personInfoResult.next()) {

                    sectionType.returnType= personInfoResult.getString(1);
                    sectionType.funcName= personInfoResult.getString(2);
                    sectionType.argString= personInfoResult.getString(3);
                    sectionType.argNumber= Integer.valueOf(personInfoResult.getString(4));
                    sectionType.sectionType= Integer.valueOf(personInfoResult.getString(5));

                    functionListArray.add(sectionType);
                }
            } catch (Exception e){
                System.out.println("hi man");
            }

        }catch (Exception e)
        {
            System.out.println("in getFunctions : "+e.getMessage());
        }
        return functionListArray;
    }
}
