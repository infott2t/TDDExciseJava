package main;

import java.util.ArrayList;
import java.io.Console;
import java.util.Scanner;

public class CustomMenu {

    String menuStr;
    ArrayList<String> menuIndexArr;  
    String menuFirstStrs = "";
    String menuFirstStrs0 = "0. Login\n1. Working on Service\n2. Rest\n3. My Page\n4. Exit\n";
    String menuFirstStrs1 = "0. Logout\n1. Working on Service\n2. Rest\n3. My Page\n4. Exit\n";
    String loginStrs = "1. Login. input id, pw \n2. New regist \n3. find id/pw\n";
    String loginRegistStrs = "Regist. Create ID. writing, id name. \n";
    String logoutStrs = "1. log out.\n";
    String ServiceStrs = "1. Product\n2.Service learning\n3.Entity(java)\n";
    String restStrs ="";
    String restStrs0 = "1. Rest start.\n";
    String restStrs1 = "1. Rest end.\n";
    String myPage0 = "1. time stamp\n2. my id\n";

    String inputIdPWStrs = "Input ID. (save template, \"Caisy\")\n";
    String inputIdPwStrs2 = "Input PW. \n";

    public CustomMenu(String menuStr) {
        this.menuStr = menuStr;
        if(menuStr == "test01"){
             
            menuIndexArr = new ArrayList<>();
        }
    }

    public void menuStrs(int menuIndex) {
        //Log in or Log out, menu. COMPLETE.
        if(menuIndex == 0){
            if(menuIndexArr.size() == 0){
                if(SessionStatic.LoginCustomer==null){
                    menuFirstStrs = menuFirstStrs0;
                }else{
                    menuFirstStrs = menuFirstStrs1;
                }
                menuIndexArr.add(menuFirstStrs);
            }else{
                if(SessionStatic.LoginCustomer==null){
                    menuFirstStrs = menuFirstStrs0;
                }else{
                    menuFirstStrs = menuFirstStrs1;
                }
                //menuIndexArr.add(menuFirstStrs);
            }
        
        System.out.println(menuFirstStrs);
        if(SessionStatic.beforeResultStr==null || SessionStatic.beforeResultStr==""){
            System.out.println(SessionStatic.beforeResultStr);
        }else{
            System.out.println(SessionStatic.beforeResultStr);
        }
        }else{
            String menuPrint = this.menuIndexArr.get(menuIndex).toString();
            System.out.print(menuPrint);
            if(SessionStatic.beforeResultStr==null|| SessionStatic.beforeResultStr==""){
                
            }else{
                System.out.println(SessionStatic.beforeResultStr);
            }
        }
        
    }

 

    public int runing(int menuIndex, String iStr, ArrayList<Customer> customers, ArrayList<TimeStamp0> timeStamp0s) {
        //System.out.println("MENU index: " + menuIndex); 
        

        SessionStatic.beforeResultStr = "";
        if(menuIndex == 0){


            if(iStr.equals("0")){//System.out.println("Login..... .\n");
            if(SessionStatic.LoginCustomer==null){
                menuIndexArr.add(loginStrs);
            }else{
                menuIndexArr.add(logoutStrs);
            }
            
        }
        else if(iStr.equals("1")){//System.out.println("Working on Service..... .");
            menuIndexArr.add(ServiceStrs);
        }
        else if(iStr.equals("2")){//System.out.println("Rest..... .");
           
            if(SessionStatic.LoginCustomer==null){
                SessionStatic.beforeResultStr= "Rest function, Login Need.";
                menuIndex = menuIndex -1;
            }else{
                System.out.println("Rest... .");
                menuIndexArr.add(restStrs0);
            }
        }
        else if(iStr.equals("3")){//System.out.println("My Page... .");
            if(SessionStatic.LoginCustomer!=null){
                menuIndexArr.add(myPage0);
            }else{
                SessionStatic.beforeResultStr = "Need login. Thank you.";
                menuIndex = menuIndex -1;
            }
            
        }
        else if(iStr.equals("4")){System.out.println("Exit..... .");}
        }
        else{
            //0. Login 
            if(menuIndexArr.get(menuIndex).toString().equals(loginStrs)){
                 
                if(iStr.equals("1")){
                    menuIndexArr.add(inputIdPWStrs);
                }else if(iStr.equals("2")){
                    menuIndexArr.add(loginRegistStrs);
                }else if(iStr.equals("3")){

                }
                
            }else if(menuIndexArr.get(menuIndex).toString().equals(loginRegistStrs)){
                System.out.println("\nMake id, \033[1;33m" + iStr+"\033[0m");
                boolean possible = true;
                for(Customer customer: customers){
                    if(customer.getIdName().equals(iStr)){
                        if(customer.getIsDel().equals("Y")){
                            possible = true;
                        }else{
                            possible = false;
                        }
                    }
                }
                if(possible){
                    String inputEmail = "";
                    String certNum ="";
                    System.out.println("\n\033[1;34mMake possible.\033[0m\n");
                    Console console = System.console();
                    if(console == null){
                        System.out.println("No console: non-interactive mode!");
                        System.exit(0);
                    }
                    char [] passwordArray0 = console.readPassword("\033[1;32m***\033[0m Enter your password: ");
                    String inputPW="";
                    String firstInputPW="";
                    for(int i =0; i< passwordArray0.length; i++){
                        //System.out.print(passwordArray[i]);
                        inputPW = inputPW + passwordArray0[i];
                        firstInputPW = inputPW;
                    }
                    char [] passwordArray1 = console.readPassword("\033[1;32m***\033[0m rewrite password: ");
                    inputPW="";
                    String twiceInputPW="";
                    for(int i =0; i< passwordArray1.length; i++){
                        //System.out.print(passwordArray[i]);
                        inputPW = inputPW + passwordArray1[i];
                        twiceInputPW = inputPW;
                    }

                    if(firstInputPW.equals(twiceInputPW)){
                        System.out.println("\n\033[1;34mpassword maked.\033[0m\n");

                        Scanner sc = new Scanner(System.in);

                        System.out.print("\033[1;32m***\033[0m Write email:");
                        inputEmail = sc.nextLine();
                        System.out.println(inputEmail);
                        System.out.println();
                        System.out.println("ID name: \033[1;33m" + iStr+"\033[0m");
                        System.out.println("Email: \033[1;33m" + inputEmail+"\033[0m");
                        System.out.println();
                        System.out.println("\033[1;32m***\033[0m Choose Role, \033[1;32m1\033[0m.ADMIN \033[1;32m2\033[0m.Customer \033[1;32m3\033[0m.Seller  Input 1~3 :");
                         
                        sc= new Scanner(System.in);
                        String inputNumber = sc.nextLine();
                        if(inputNumber.equals("1") || inputNumber.equals("2") || inputNumber.equals("3")){
                            String roleStr = "";
                            if(inputNumber.equals("1")){ roleStr = "ADMIN";
                            System.out.println("\033[1;32m***\033[0m Cert number need: ");
                            sc = new Scanner(System.in);
                            certNum = sc.nextLine();
                            }
                            if(inputNumber.equals("2")){ roleStr = "Customer";}
                            if(inputNumber.equals("3")){ roleStr = "Seller";}
                            System.out.println("\nID name: \033[1;33m" + iStr+"\033[0m");
                            System.out.println("Email: \033[1;33m" + inputEmail+"\033[0m");
                            System.out.println("Role: \033[1;33m" + roleStr+"\033[0m");
                            if(inputNumber.equals("1")){
                                System.out.println("Cert number: \033[1;33m" + certNum+"\033[0m");
                            }
                            System.out.println("\033[1;32m***\033[0m Is collect and Make id (Y/N)?");
                            sc = new Scanner(System.in);
                            String ynStr = sc.nextLine();
                            if(ynStr.equals("Y") || ynStr.equals("y")){
                                System.out.println("\033[1;34mMake complete.\033[0m");
                                try{
                                    Thread.sleep(2000);
                                }catch(Exception e){
                                    e.printStackTrace();
                                }
                                SessionStatic.beforeResultStr = "Regist Complete. New id, \033[1;33m"+ iStr+"\033[0m" ;
                                menuIndex = -1;
                            }else if(ynStr.equals("N") || ynStr.equals("n")){
                                System.out.println("ID make fail.");
                                menuIndex =  -1;
                                SessionStatic.beforeResultStr = "ID make fail.";
                            }else{
                                System.out.println("ID make fail.");
                                menuIndex =  -1;
                                SessionStatic.beforeResultStr = "ID make fail.";
                            }

                        }else{
                            System.out.println("Wrong input. Please retry. Thank you.");
                            SessionStatic.beforeResultStr="Incollect password. Retry.";
                            menuIndex = menuIndex -1;
                        }

                    }else{
                        System.out.println("Incollect password. Retry.");
                        SessionStatic.beforeResultStr="Incollect password. Retry.";
                        menuIndex = menuIndex -1;
                    }
                   
                    
                }else{
                    System.out.println("Impossible making id. Please another id writing.");
                    SessionStatic.beforeResultStr = "Impossible making id. Please another id writing.";
                    menuIndex = menuIndex -1;
                }
            }
             else if(menuIndexArr.get(menuIndex).toString().equals(logoutStrs)){
                if(iStr.equals("1")){
                    System.out.println("Log out.");
    
                    SessionStatic.beforeResultStr="Log out, "+ SessionStatic.LoginCustomer.getIdName();
                    SessionStatic.Stamp0 = new TimeStamp0(SessionStatic.LoginCustomer.getId(), "LOG_OUT" );
                    SessionStatic.LoginCustomer = null;
                    timeStamp0s.add(SessionStatic.Stamp0);
                    this.remove(menuIndex);
                    menuIndex = -1;
                }
            } 
            else if(menuIndexArr.get(menuIndex).toString().equals(inputIdPWStrs)){
                System.out.println("ID input, \033[1;33m"+ iStr+"\033[0m");
                System.out.println("\033[1;32m*\033[0mFinding id name, " + iStr+" ...");
                try{
                    Thread.sleep(2000);
                }catch(Exception e){
                    e.printStackTrace();
                }

                String findIdName = iStr;
                Customer foundCustomer = null;

                for(Customer customer: customers ){
                    if(customer.getIdName().equals(findIdName)){
                        if(customer.getIsDel().equals("N")){
                            foundCustomer = customer;
                            SessionStatic.LoginCustomer = new Customer(foundCustomer.getId(), foundCustomer.getIdName(), null, null, null);
                            SessionStatic.Stamp0 = new TimeStamp0(SessionStatic.LoginCustomer.getId(), "LOG_IN" );
                            timeStamp0s.add(SessionStatic.Stamp0);
                            break;
                        }
                 }
             }
                if(foundCustomer !=null){
                    System.out.println("Found customer: " + foundCustomer.getIdName());
                    System.out.println();
                    System.out.println("Input PW: (templeate, \"1234\")");
                    Console console = System.console();
                    if(console == null){
                        System.out.println("No console: non-interactive mode!");
                        System.exit(0);
                    }
                    char [] passwordArray = console.readPassword("\033[1;32m***\033[0mEnter your password: ");
                    String inputPW="";
                    String findPW="";
                    for(int i =0; i< passwordArray.length; i++){
                        //System.out.print(passwordArray[i]);
                        inputPW = inputPW + passwordArray[i];
                        findPW = inputPW;
                    Customer foundCustomer2 = null;
                        
                    }
                    for(Customer customer: customers ){
                        if(customer.getIdName().equals( SessionStatic.LoginCustomer.getIdName())){
                            if(customer.getPassword().equals(findPW)){
                                SessionStatic.LoginCustomer = customer;
                                break;
                            }
                        }
                    }
                    if(SessionStatic.LoginCustomer.getId()!=null ){
                        System.out.println("Login success.");
                        SessionStatic.beforeResultStr="\033[1;34mLogin success.\033[0m";
                        this.remove(menuIndex);
                        this.remove(menuIndex-1);
                        this.remove(menuIndex-2);
                        menuIndex = menuIndex -3;
                        sleep();
                        
                    }else{
                        System.out.println("Login fail.");
                        SessionStatic.beforeResultStr="\033[1;34mLogin fail.\033[0m";
                        this.remove(menuIndex);
                        this.remove(menuIndex-1);
                        this.remove(menuIndex-2);
                        menuIndex = menuIndex -3;
                    }
                }else{
                    System.out.println("Customer not found");
                    this.remove(menuIndex);
                    SessionStatic.beforeResultStr = "\033[1;34mCustomer not founded. Return menu.\033[0m";
                    menuIndex = -1;
                }
                

            }
             
            //else if 2. Rest.
            else if(menuIndexArr.get(menuIndex).toString().equals(restStrs0)){
                if(iStr.equals("1")){
                    SessionStatic.Stamp0 = new TimeStamp0(SessionStatic.LoginCustomer.getId(), "REST" );
                  
                    timeStamp0s.add(SessionStatic.Stamp0);
                    SessionStatic.beforeResultStr= "\n--"+SessionStatic.Stamp0.getFormatDateTime2()+" -- Rest start.";
                    menuIndexArr.add(restStrs1);
                }
            }
            else if(menuIndexArr.get(menuIndex).toString().equals(restStrs1)){
                if(iStr.equals("1")){
                    SessionStatic.Stamp0 = new TimeStamp0(SessionStatic.LoginCustomer.getId(), "REST" );
                  
                    timeStamp0s.add(SessionStatic.Stamp0);
                    SessionStatic.beforeResultStr= "\n--"+SessionStatic.Stamp0.getFormatDateTime2()+" -- Rest end.";
                    this.remove(menuIndex);
                    this.remove(menuIndex-1);
                    menuIndex = -1;
                }
            }
            // else if 3. My Page,  1. time stamp\n2. my id
            else if(menuIndexArr.get(menuIndex).toString().equals(myPage0)){
                if(SessionStatic.LoginCustomer!=null){
                    if(iStr.equals("1")){
                        // log time stamp.
                        // find TimeStamp0.
                        ArrayList<TimeStamp0> tsList = new ArrayList<TimeStamp0>();
                        for(int i=0; i<timeStamp0s.size(); i++){
                            if(timeStamp0s.get(i).getWhoId()==SessionStatic.LoginCustomer.getId()){
                                tsList.add(timeStamp0s.get(i));
                            }
                        }
                        System.out.println("Stamping. ...");
                        String textStrs = "Stamping. ...\n\n";
                        for(int i=0; i<timeStamp0s.size();i++){
                            
                            textStrs = textStrs +  tsList.get(i).getFormatDateTime2() + " | "+ tsList.get(i).getTodo()+ " | " + SessionStatic.LoginCustomer.getIdName() +"\n";
                        }
                        textStrs = textStrs + "\nViewer: \n       " + SessionStatic.LoginCustomer.getIdName() + " (role: " + SessionStatic.LoginCustomer.getRole() + " email: " + SessionStatic.LoginCustomer.getEmail()+" )";
                        System.out.println(textStrs);
                        System.out.println("\n ... Done.");
                        new SwingTextArea("Time Stamp", textStrs,370,370);
                        this.remove(menuIndex);
                        menuIndex = menuIndex -2;

                    }
                    else if(iStr.equals("2")){
                        String textStrs = "";
                        System.out.println("My infomation");
                        System.out.println("ID: " + SessionStatic.LoginCustomer.getId());
                        System.out.println("ID NAME: " + SessionStatic.LoginCustomer.getIdName());
                        System.out.println("EMAIL : " + SessionStatic.LoginCustomer.getEmail());
                        System.out.println("ROLE : " + SessionStatic.LoginCustomer.getRole());
                        textStrs = "My Information\nID: "+SessionStatic.LoginCustomer.getId()+ "\n"
                                    +"ID NAME: " + SessionStatic.LoginCustomer.getIdName()+ "\n"
                                    +"EMAIL : " + SessionStatic.LoginCustomer.getEmail() + "\n"
                                    +"ROLE : "+ SessionStatic.LoginCustomer.getRole()+"\n";
                        new SwingTextArea("My information", textStrs,370,150);            
                        this.remove(menuIndex);
                        menuIndex = menuIndex -2;
                                
                    }
                }else{
                    SessionStatic.beforeResultStr="Need login~. Thank you.";
                    menuIndex = menuIndex-2;
                }
            }
        }
      
           
        

        return menuIndex;
    }

    public void remove(int menuIndex) {
        menuIndexArr.remove(menuIndex);
    }

    public void sleep(){
        try{
            Thread.sleep(2000);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
