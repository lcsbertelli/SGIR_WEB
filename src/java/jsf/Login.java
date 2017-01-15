/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf;

import jpa.entities.Usuario;

/**
 *
 * @author msndo
 */
public class Login {
    
    Usuario user = new Usuario();
    private String email; 
    private String password;  

    
 
    public String getPassword1() {
        return password;
    }
    
    public String getEmail() {
    return email;
    }

    public void setEmail(String x){
    this.email=x;
    }
    
    
    public void setPassword(String x){
    this.password=x;
    }
    
}
