package main;


public class Customer {

    private Long id;
    private String idName;
    private String email;
    private String role; // Customer, Seller, Admin 
    private String password; //암호화 필요.
    
    Customer(Long id, String idName, String email, String role, String password){
        this.id = id;
        this.idName = idName;
        this.email = email;
        this.role = role;
        this.password = password;  
    }

    String getIdName(){
        return this.idName;
    }

    String getPassword(){
        return this.password;
    }

    Long getId(){
        return this.id;
    }

}
