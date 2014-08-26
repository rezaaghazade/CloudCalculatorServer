package org.cloud.fields;

/**
 * Created by reza on 7/23/14.
 */
public class PHYSIC {

    public Double CIRCLEAREA(Double a)
    {
        return Math.PI*Math.pow(a,2);
    }
    public Double DENSITY(Double a,Double b)
    {
        return a/b;
    }
    public Double Cube(Double a)
    {
        return Math.pow(a,3);
    }

public Double Consecutive(Double n)    {        return ( ( n * ( n + 1 ) * ( 2*n + 1 ) ) / 6);    }}