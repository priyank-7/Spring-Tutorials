package com.spring.core;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Coach theCaoch = new TrackCoach();
        System.out.println(theCaoch.getDailyWorkout());
    }
}
