package org.cloud.compiler;

import org.j2os.shine.util.JavaCompiler;

/**
 * Created by reza on 8/6/14.
 */
public class ServerCompiler {

    public boolean addMethod(String className,String func)throws Exception
    {
        System.out.println("in Add Method..Before Inserting");
        System.out.println(className);
        System.out.println(func);
        JavaCompiler javaCompiler = new JavaCompiler();

        String path=System.getProperty("java.home");

        int lenght=path.length();

        String newPath = path.substring(0, lenght-3);
        newPath+="bin/javac";

        try {
            javaCompiler.addSource("/home/reza/","bat",newPath,
                    "./out/production/CloudCalculatorServer",
                    "./src/org/cloud/fields/"+className+".java",func);
            System.out.println("in Add Method..After Inserting");
            return true;
        }catch (Exception e)
        {
            System.out.println(e.getMessage());
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
