package org.cloud.compiler;

import org.j2os.shine.util.JavaCompiler;
import org.j2os.shine.util.SystemRoot;

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
            /*javaCompiler.addSource("/home/reza/",
                    "bat",
                    newPath,
                    "./out/production/CloudCalculatorServer",
                    "./src/org/cloud/fields/"+className+".java",
                    func);*/


            /*func="public Double Cube(Double a)\n" +
                    "    {\n" +
                    "        return Math.pow(a,3);\n" +
                    "    }";
*/
            SystemRoot systemRoot = new SystemRoot();
            String content;
            content = systemRoot.getContentFile("./src/org/cloud/fields/"+className+".java");
            content = content.substring(0, content.lastIndexOf("}")) + func +"}";
            systemRoot.writeContentFile("./src/org/cloud/fields/"+className+".java", content);

            String osCommand=javcAdd+" -d "+"./out/production/CloudCalculatorServer "+"./src/org/cloud/fields/"+className+".java";

            Process process = Runtime.getRuntime().exec(osCommand);


            return true;
        }catch (Exception e)
        {
            System.out.println("oohoho " + e.getMessage());
            return false;
        }



    }

 /*   public static void main(String[] args) {
        ServerCompiler serverCompiler=new ServerCompiler();
        try {
            serverCompiler.addMethod("MATHEMATIC","public void reza(){ int i = 4+6; System.out.println(i); }");
        }catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

    }*/
}
