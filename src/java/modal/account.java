/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modal;

/**
 *
 * @author asus
 */
public class account {
    
    private String accountuser,passuser;
    private  int role;

    public account() {
    }

    public account(String accountuser, String passuser, int role) {
        this.accountuser = accountuser;
        this.passuser = passuser;
        this.role = role;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }
    
    public account(String accountuser, String passuser) {
        this.accountuser = accountuser;
        this.passuser = passuser;
    }

    public String getAccountuser() {
        return accountuser;
    }

    public String getPassuser() {
        return passuser;
    }

    public void setAccountuser(String accountuser) {
        this.accountuser = accountuser;
    }

    public void setPassuser(String passuser) {
        this.passuser = passuser;
    }
    
    
}
