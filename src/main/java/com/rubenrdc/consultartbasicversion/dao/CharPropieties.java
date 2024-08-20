package com.rubenrdc.consultartbasicversion.dao;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 * @author Ruben
 */
public class CharPropieties {

    private static String ip = "";
    private static String user = "";
    private static String pass = "";
    private static String bd = "";
    private static String key = "";
    private static String iv = "";

    private final static String TIPO_CIFRADO = "AES/CBC/PKCS5Padding";
    private final static String ALGORITM = "AES";

    public CharPropieties() {
        iniciar();
    }

    private void iniciar() {

        Properties propiedades = new Properties();
        InputStream file = null;
        String userDirectoryPath = System.getProperty("user.dir");
        //javax.swing.JOptionPane.showMessageDialog(null, userDirectoryPath);
        try {
            

            file = new FileInputStream(userDirectoryPath+"/datos.properties");
            //System.out.println("ES NULO");
            propiedades.load(file);
            
            key = propiedades.getProperty("key");
            iv = propiedades.getProperty("iv");
            ip = decrypt(key, iv, propiedades.getProperty("ip"));
            user = decrypt(key, iv, propiedades.getProperty("user"));
            pass = decrypt(key, iv, propiedades.getProperty("pass"));
            bd = decrypt(key, iv, propiedades.getProperty("bd"));
        } catch (Exception rx) {
            javax.swing.JOptionPane.showMessageDialog(null, rx);
            
        }
    }

    private static String decrypt(String key, String iv, String encryted) throws Exception {
        javax.crypto.Cipher c = javax.crypto.Cipher.getInstance(TIPO_CIFRADO);
        javax.crypto.spec.SecretKeySpec sKeySpec = new javax.crypto.spec.SecretKeySpec(key.getBytes(), ALGORITM);
        javax.crypto.spec.IvParameterSpec ivParaMet = new javax.crypto.spec.IvParameterSpec(iv.getBytes());
        byte[] enc = java.util.Base64.getDecoder().decode(encryted);
        c.init(javax.crypto.Cipher.DECRYPT_MODE, sKeySpec, ivParaMet);
        byte[] decryted = c.doFinal(enc);
        return new String(decryted);
    }

    private static String decodeTextBase64(String txt) {
        byte[] decoded = java.util.Base64.getDecoder().decode(txt);
        return new String(decoded);
    }

    public static String getIp() {
        return ip;
    }

    public static String getUser() {
        return user;
    }

    public static String getPass() {
        return pass;
    }

    public static String getBd() {
        return bd;
    }

    public static String getKey() {
        return key;
    }

    public static String getIv() {
        return iv;
    }
}
