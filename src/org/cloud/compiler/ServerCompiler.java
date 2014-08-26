package org.cloud.compiler;

import org.j2os.shine.util.JavaCompiler;
import org.j2os.shine.util.SystemRoot;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

/**
 * Created by reza on 8/6/14.
 */
public class ServerCompiler {

    public boolean addMethod(String className,String func)throws Exception
    {
        JavaCompiler javaCompiler = new JavaCompiler();

        String path=System.getProperty("java.home");

        int lenght=path.length();

        String javcAdd = path.substring(0, lenght-3);
        javcAdd+="bin/javac";

        try {

            File file = new File("./src/org/cloud/temp/"+className+".java");

            file.createNewFile();

            SystemRoot systemRoot = new SystemRoot();

            String content;
            content = systemRoot.getContentFile("./src/org/cloud/fields/"+className+".java");

            content = content.substring(0, content.lastIndexOf("}")) + func +"}";

            String tempStart="package org.cloud.temp;\n";
            content = content.substring(content.indexOf('\n')+1);

            systemRoot.writeContentFile("./src/org/cloud/temp/"+className+".java", tempStart+content);
            String osCommand=javcAdd+" -d "+"./out/production/CloudCalculatorServer "+"./src/org/cloud/temp/"+className+".java";

            Process process = Runtime.getRuntime().exec(osCommand);

            BufferedReader input = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            int counter=0;
            String line;
            while ((line = input.readLine()) != null) {
                counter++;
            }
            System.out.println("Counter : "+counter);
            systemRoot.delete("./src/org/cloud/temp/"+className+".java");
            if (counter!=0)
            {
                return false;
            }else {
                String basicStart="package org.cloud.fields;\n";
                systemRoot.writeContentFile("./src/org/cloud/fields/" + className + ".java", basicStart+content);
                osCommand=javcAdd+" -d "+"./out/production/CloudCalculatorServer "+"./src/org/cloud/fields/"+className+".java";
                process = Runtime.getRuntime().exec(osCommand);
            }

            return true;
        }catch (Exception e)
        {
            System.out.println("oohoho " + e.getMessage());
            return false;
        }



    }

    public static void main(String[] args) {
        ServerCompiler serverCompiler=new ServerCompiler();
        try {
            serverCompiler.addMethod("MATHEMATIC","public void reza(){ int i = 4+6; System.out.println(i); }");
        }catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

    }
}
