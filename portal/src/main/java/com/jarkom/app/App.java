package com.jarkom.app;


public class App 
{
    private Portal server = new Portal();
    public static void main( String[] args )
    {
        //server.initiateWorker();
        server.listen();
    }
}
