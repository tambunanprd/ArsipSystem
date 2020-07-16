/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arsipsistem;

import java.awt.FileDialog;
import java.awt.Frame;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author tam
 */
public class AES256 {
    private static  SecretKeySpec secretKey;
    private static byte[] key;
    private static final String ALGORITMA = "AES";
    private static final String TRANSFORM = "AES/ECB/PKCS5PADDING";

public static void setKey(String userKey) {
 MessageDigest sha = null ;
 
    try {
        key = userKey.getBytes();
        
        sha = MessageDigest.getInstance("SHA-256");
        
        key = sha.digest(key);
        key = Arrays.copyOf(key, 16);
        secretKey = new SecretKeySpec(key,ALGORITMA);
    } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
    }
}

public static String encrypt(String kunci, String plainteks) {
    try {
        setKey(kunci);
        Cipher cipher = Cipher.getInstance(TRANSFORM);
        
        cipher.init(Cipher.ENCRYPT_MODE , secretKey);
        byte[] cipherteks = cipher.doFinal(plainteks.getBytes());
        
        return Base64.getEncoder().encodeToString(cipherteks);
    } catch (Exception e) {
        System.err.println("Enkripsi eror : " + e.toString());
    }
    return null;
}
public static String  decrypt(String kunci, String cipherteks) {
    try {
        setKey(kunci);
        Cipher cipher = Cipher.getInstance(TRANSFORM);
        
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        return new String(cipher.doFinal(Base64.getDecoder().decode(cipherteks)));
    } catch (Exception e) {
        System.err.println("Dekripsi error :" + e.toString());
    }
    return null;
}

public static boolean doCryptoFile(int cipherMode, String Key, File inputFile, File outputFile ){
    try {
        setKey(Key);
        Cipher cipher =  Cipher.getInstance(TRANSFORM);
        
        cipher.init(cipherMode, secretKey);
        
        System.out.println("Reading file");
        FileInputStream inputStream = new FileInputStream(inputFile);
        byte[] inputBytes = new byte[(int) inputFile.length()];
        inputStream.read(inputBytes);
        
        System.out.println("Crypt the file "+inputFile.getName());
        byte[] outputBytes = cipher.doFinal(inputBytes);
        System.out.println("Writing to file");
        FileOutputStream outputStream = new FileOutputStream(outputFile);
        outputStream.write(outputBytes);
        
        inputStream.close();
        outputStream.close();
        return true;
        
    } catch (BadPaddingException e) {
        System.out.println("Kunci tidak cocok " +e.toString());
        outputFile.delete();
        return false;
    } catch (Exception e) {
    System.out.println("Enkripsi eror : "+e.toString());
    outputFile.delete();
    return false;
    } 
}
// susah amat -_-
    public static boolean encryptFile(String key, File inputFile, File outputFile) {
        try {
            setKey(key);
            String file = inputFile.getAbsolutePath();
            Cipher cipher = Cipher.getInstance(TRANSFORM);
            cipher.init(Cipher.ENCRYPT_MODE,secretKey);
            
            FileInputStream inputStream = new FileInputStream(inputFile);
            String inputString;
            byte[] inputBytes = new byte[(int) inputFile.length()];
            inputStream.read(inputBytes);
            //tanda untuk marking
            file = file+"###";
            
            byte[] fileByte = file.getBytes();
            ByteArrayOutputStream outputStreams = new ByteArrayOutputStream();
            outputStreams.write(fileByte);
            outputStreams.write(inputBytes);
            byte allInputByte[] = outputStreams.toByteArray();
            System.out.println("Enkripsi file" + inputFile.getName());
            byte[] outputBytes = cipher.doFinal(allInputByte);
            //proses enkripsi
            FileOutputStream outputStream = new FileOutputStream(outputFile);
            byte[] filetoWrite = cipher.doFinal(file.getBytes());
            outputStream.write(outputBytes);
            inputStream.close();
            outputStream.close();
            return true;
        } catch (BadPaddingException e) {
            System.out.println("Password salah! "+e.toString());
            outputFile.delete();
            return false;
        } catch (Exception e) {
            System.out.println("Gagal mengenkripsi: "+e.toString());
            outputFile.delete();
            return false;
        }
        
    }




public static boolean decryptFile (String key, File inputFile, File outputFile) {
    try {
            setKey(key);
            Cipher cipher = Cipher.getInstance(TRANSFORM);
            cipher.init(Cipher.DECRYPT_MODE,secretKey);
          
            FileInputStream inputStream = new FileInputStream(inputFile);
            byte[] inputBytes = new byte[(int) inputFile.length()];
            inputStream.read(inputBytes);
            
            System.out.println("Enkripsi File" + inputFile.getName());
            byte[] outputBytes = cipher.doFinal(inputBytes);
            String outputString = new String(outputBytes);
            String[] allString = outputString.split("###");
            String file = allString[0];
            outputString = allString[1];
            outputBytes=outputString.getBytes();
           
            FileOutputStream outputStream = new FileOutputStream(file);
            outputStream.write(outputBytes);
            
            inputStream.close();
            outputStream.close();
            return true;
        } catch (BadPaddingException e) {
            System.out.println("Kunci tidak cocok! "+e.toString());
           
            return false;
        } catch (Exception e) {
            System.out.println("Gagal mengdekripsi: "+e.toString());
       
            return false;
        }
    }




public static void main(String[] args) {

String key = "file kita";

 FileDialog dialog = new FileDialog((Frame)null, "Select File to Open");
    dialog.setMode(FileDialog.LOAD);
    dialog.setVisible(true);
    String file = dialog.getFile();
    File inputFile = new File (file);
    File encryptedFile = new File ("file.encrypted.pdf");
    File decryptedFile = new File ("file.decrypted.pdf");

        try {
            AES256.encryptFile(key, inputFile, encryptedFile);
            AES256.decryptFile(key, encryptedFile, decryptedFile);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }
}