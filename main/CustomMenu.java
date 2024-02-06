package main;

import java.util.ArrayList;
import java.io.Console;

public class CustomMenu {

    String menuStr;
    ArrayList<String> menuIndexArr;  
    String menuFirstStrs = "0. Login\n1. Working on Service\n2. Rest\n3.Exit\n";
    String loginStrs = "1. input id, pw \n2. New regist \n3. find id/pw\n";
    String ServiceStrs = "1. Product\n2.Service learning\n3.Entity(java)\n";

    String inputIdPWStrs = "Input ID. (save template, \"Caisy\")\n";
    String inputIdPwStrs2 = "Input PW. \n";

    public CustomMenu(String menuStr) {
        this.menuStr = menuStr;
        if(menuStr == "test01"){
            System.out.println("test01...");
            menuIndexArr = new ArrayList<>();
        }
    }

    public void menuStrs(int menuIndex) {
        if(menuIndex == 0){
            if(menuIndexArr.size() == 0){
                menuIndexArr.add(menuFirstStrs);
            }
        
        System.out.println(menuFirstStrs);
        }else{
            String menuPrint = this.menuIndexArr.get(menuIndex).toString();
            System.out.print(menuPrint);
        }
        
    }

 

    public int runing(int menuIndex, String iStr, ArrayList<Customer> customers) {
        System.out.println("MENU index: " + menuIndex);
        if(menuIndex == 0){
            if(iStr.equals("0")){System.out.println("Login..... .\n");
            menuIndexArr.add(loginStrs);
        }
        else if(iStr.equals("1")){System.out.println("Working on Service..... .");
            menuIndexArr.add(ServiceStrs);
        }
        else if(iStr.equals("2")){System.out.println("Rest..... .");}
        else if(iStr.equals("3")){System.out.println("Exit..... .");}
        }
        else if(menuIndex == 1){
            if(iStr.equals("1")){
                if(menuIndexArr.get(menuIndex).toString().equals(loginStrs)){
                    System.out.println("menuIndexArr.get(menuIndex-1).toString() index 1");
                    menuIndexArr.add(inputIdPWStrs);
                }
            }  
        }else if(menuIndexArr.get(menuIndex).toString().equals(inputIdPWStrs)){
            System.out.println("ID input, "+ iStr);
            System.out.println("*Find id name, " + iStr);
            try{
                Thread.sleep(2000);
            }catch(Exception e){
                e.printStackTrace();
            }

            String findIdName = iStr;
            Customer foundCustomer = null;

            for(Customer customer: customers ){
                if(customer.getIdName().equals(findIdName)){
                    foundCustomer = customer;
                    SessionStatic.LoginCustomer = new Customer(null, foundCustomer.getIdName(), null, null, null);
                    break;
                }
            }
            if(foundCustomer !=null){
                System.out.println("Found customer: " + foundCustomer.getIdName());
                System.out.println("Input PW: (templeate, \"1234\")");
                Console console = System.console();
                if(console == null){
                    System.out.println("No console: non-interactive mode!");
                    System.exit(0);
                }
                char [] passwordArray = console.readPassword("Enter your password: ");
                String inputPW="";
                String findPW="";
                for(int i =0; i< passwordArray.length; i++){
                    System.out.print(passwordArray[i]);
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
                    menuIndex = menuIndex -3;
                }else{
                    System.out.println("Login fail.");
                    menuIndex = menuIndex -3;
                }
            }else{
                System.out.println("Customer not found");
                menuIndex = menuIndex -1;
            }
            

        }

        return menuIndex;
    }

    public void remove(int menuIndex) {
        menuIndexArr.remove(menuIndex);
    }
    
}
