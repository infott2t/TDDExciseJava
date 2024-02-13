package main;

public  class SessionStatic {
    
    static Customer LoginCustomer;
    static TimeStamp0 Stamp0;
    static String beforeResultStr="";

    SessionStatic(){
        LoginCustomer = null;
        Stamp0 = null;
        beforeResultStr = "";
    }
}
