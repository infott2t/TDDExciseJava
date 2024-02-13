package main;
import java.util.Date;

public class Customer {

    private Long id;
    private String idName;
    private String email;
    private String role; // Customer, Seller, Admin 
    private String password; //암호화 필요.
    private String certNum;

    private String isDel;
    private Date createDate;
    
    Customer(Long id, String idName, String email, String role, String password){
        this.id = id;
        this.idName = idName;
        this.email = email;
        this.role = role;
        this.password = password;  

        this.isDel ="N";
        this.createDate = new Date();
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

    public String getRole() {
        return role;
    }

    public String getEmail() {
        return email;
    }

    public String getIsDel() {
        return isDel;
    }

    public void setCertNum(String certNum) {
        this.certNum = certNum;
    }

}
