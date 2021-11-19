/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbmsproj;
//import dbmsproj.ReceptionistLogin;
import java.util.Base64;    
import javax.crypto.Cipher;  
import javax.crypto.KeyGenerator;   
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
//import org.apache.commons.codec.binary.Base64;

/**
 *
 * @author Aman
 */
public class Encryption {
    static Cipher c;
    private byte[] keyValue;
    public Encryption(String key)
    {
        keyValue=key.getBytes();
    }
    public String encrypt(String pass) throws Exception{
        Encryption enc=new Encryption("PdSgVkYp3s6v9y$B");
        Key key=generateKey();
        Cipher c=Cipher.getInstance("AES");
        c.init(Cipher.ENCRYPT_MODE, key);
        byte[] encVal=c.doFinal(pass.getBytes());
        Base64.Encoder encoder=Base64.getEncoder();
        String encryptedText = encoder.encodeToString(encVal);
        return encryptedText;
        
    }
    private String decrypt(String encryptedData) throws Exception
    {
        Key key=generateKey();
        Cipher c=Cipher.getInstance("AES");
        c.init(Cipher.DECRYPT_MODE,key);
        Base64.Decoder decoder = Base64.getDecoder();
        byte[] encryptedTextByte=decoder.decode(encryptedData);
        byte[] decryptedByte=c.doFinal(encryptedTextByte);
        String decryptedValue=new String(decryptedByte);
        return decryptedValue;
    }
    private Key generateKey() throws Exception
    {
        Key key=new SecretKeySpec(keyValue,"AES");
        return key;
    }
    public static void main(String[] args) throws Exception
    {
        String pass="abc";
        Encryption enc=new Encryption("PdSgVkYp3s6v9y$B");
        String encdata=enc.encrypt("asdf1");
        System.out.println(encdata);
        //String dec=enc.encrypt(encdata);
        //System.out.println(dec);
        
        
        
    }
}
