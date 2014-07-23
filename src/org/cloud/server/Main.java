package org.cloud.server;

import org.j2os.shine.util.reflect.Application;

/**
 * Created by reza on 7/23/14.
 */
public class Main {
    public static void main(String[] args)throws Exception{

        Application application=new Application();
        application.distribute(1099,"cloudCalculator",true);

    }
}
