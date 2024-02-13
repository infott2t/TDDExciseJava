package main;

import java.util.Scanner;
import java.io.IOException;
import java.util.ArrayList;

public class TddStart {

    static Customer LoginCustomer;

    public static void main(String args[]){
        System.out.print("\033[1;33m");
        System.out.println("TDD~. TDDExciseJava.");
        System.out.print("\033[0m");
        System.out.println("Enjoy~. This github, https://github.com/infott2t/TDDExciseJava\n");
        
        LoginCustomer = null; //로그인 초기화.

        int menuIndex = 0;
        
    
        CustomMenu menu = new CustomMenu("test01");
         
        //ID 초기화. - SQL 연결 필요
        ArrayList<Customer> customers = new ArrayList<>();
        ArrayList<TimeStamp0> timeStamp0s = new ArrayList<>();
        
        Customer cus = new Customer(1L, "Caisy","caisy@email.com","Admin","1234");
        //Role이 admin일 경우, 자격증 번호가 필요. 개인정보취급사 등. 
        cus.setCertNum("00000000");

        customers.add(cus);
        do{
            menuIndex = processMenu(menuIndex, menu, customers, timeStamp0s);

            try {
                if (System.getProperty("os.name").contains("Windows")) {
                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                } else {
                    Runtime.getRuntime().exec("clear");
                }
            } catch (IOException | InterruptedException ex) {
                ex.printStackTrace();
            }
           
          
            menuIndex ++;
        }while(menuIndex >=0);

    }// main end

    static int processMenu(int menuIndex, CustomMenu menu, ArrayList<Customer> customers, ArrayList<TimeStamp0> timeStamp0s){
        if(SessionStatic.LoginCustomer!=null){
            if(SessionStatic.LoginCustomer.getId()!=null){
                System.out.println("\033[1;32mStatus\033[0m: Log in, \033[1;34m"+SessionStatic.LoginCustomer.getIdName()+"\033[0m");
            }
        }else{
            System.out.println("\033[1;32mStatus\033[0m: No log in.");
        }
       
        System.out.println("\033[1;32mString\033[0m [back] [break] [view menu]");
        System.out.println("\033[1;32mMenu\033[0m "+menuIndex+"\033[1;32m *************************\033[0m");

        menu.menuStrs(menuIndex);
        
        try {
            Scanner sc = new Scanner(System.in);

            String iStr = "";
            
            System.out.print("\033[1;34minput, : \033[0m");
            iStr = sc.nextLine();
            //System.out.println(iStr+ " input.");
            
            if(iStr.equals("break")){
                menuIndex = -2;
                System.out.println("--------->Break.");
            }else if(iStr.equals("back")){
                SessionStatic.beforeResultStr="";
                if(menuIndex == 1){
                    menu.remove(menuIndex);
                    menuIndex = menuIndex-2;
                  
                }else{
                    menu.remove(menuIndex);
                    menuIndex = menuIndex -2;
                    //System.out.println("--------->menuIndex, " + menuIndex);
                    if(menuIndex <0){
                        menuIndex = -1;
                        System.out.println("--------->Break.");
                    }
                }
             
            }else if(iStr.equals("view menu")){
                

            }else if(iStr.equals("")){
                System.out.println("No input..... .");
                if(menuIndex == 0){
                    menuIndex = menuIndex -1;
                }else{
                    menuIndex = menuIndex -1;
                }
                SessionStatic.beforeResultStr="";
                
            }else{
                    menuIndex = menu.runing(menuIndex, iStr, customers,timeStamp0s);
                    
                
            }
           
             
        } catch (Exception e) {
            // TODO: handle exception
        }
        return menuIndex;
    }
}
