package test;

import org.j2os.shine.util.SystemRoot;
import org.j2os.shine.util.SystemRuntime;

/**
 * Created by reza on 8/22/14.
 */
public class test{

    public static long session_id = 0;

    public static void main(String[] args)throws Exception{


        try {

            String path=System.getProperty("java.home");

            int lenght=path.length();

            String javcAdd = path.substring(0, lenght-3);
            javcAdd+="bin/javac";

            String func="public Double Cube(Double a)\n" +
                    "    {\n" +
                    "        return Math.pow(a,3);\n" +
                    "    }";

            SystemRoot systemRoot = new SystemRoot();
            String content;
            content = systemRoot.getContentFile("./src/org/cloud/fields/MATHEMATIC.java");
            content = content.substring(0, content.lastIndexOf("}")) + func +"}";
            systemRoot.writeContentFile("./src/org/cloud/fields/MATHEMATIC.java", content);

            String osCommand=javcAdd+" -d "+"./out/production/CloudCalculatorServer "+"./src/org/cloud/fields/MATHEMATIC.java";

            Process process = Runtime.getRuntime().exec(osCommand);

            //SystemRuntime systemRuntime = new SystemRuntime();

        }catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

    }

}























