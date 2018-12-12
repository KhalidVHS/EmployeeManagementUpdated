/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.abdurkhalid.ems;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;


/**
 *
 * @author 568789
 */
public class HexForPass {
    String password;
    String passWordInHex;
    
    
public HexForPass(String password,String passWordInHex) {
this.password = password;
this.passWordInHex = convertPassToHex(this.password); 
}
public String convertPassToHex(String password){
return String.format("%040x", new BigInteger(1, password.getBytes(StandardCharsets.UTF_8)));
}
}
